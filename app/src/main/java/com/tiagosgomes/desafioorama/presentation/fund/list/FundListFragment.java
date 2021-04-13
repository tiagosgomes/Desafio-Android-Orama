package com.tiagosgomes.desafioorama.presentation.fund.list;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tiagosgomes.desafioorama.R;
import com.tiagosgomes.desafioorama.domain.Fund;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FundListFragment extends Fragment implements FundListContract.View {

    private FundListContract.Presenter mPresenter;

    @BindView(R.id.fund_list_filter_button)
    Button mFilterButton;

    @BindView(R.id.fund_list_loading)
    ProgressBar mLoadingView;

    @BindView(R.id.fund_list_error)
    TextView mErrorView;

    @BindView(R.id.fund_list_empty)
    TextView mEmptyView;

    @BindView(R.id.fund_list_recycler_view)
    RecyclerView mRecyclerView;
    FundListAdapter mAdapter;

    private List<Integer> mFilterSelectedItems = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new FundListPresenter(this);

        mFilterSelectedItems.add(1);
        mFilterSelectedItems.add(2);
        mFilterSelectedItems.add(3);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fund_list, container, false);

        ButterKnife.bind(this, view);

        mFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean[] isSelected = {false, false, false};
                for (int i = 0; i < mFilterSelectedItems.size(); i++) {
                    switch (mFilterSelectedItems.get(i)) {
                        case 1:
                            isSelected[0] = true;
                            break;
                        case 2:
                            isSelected[1] = true;
                            break;
                        case 3:
                            isSelected[2] = true;
                            break;
                    }
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                // Set the dialog title
                builder.setTitle("Filtro")
                        // Specify the list array, the items to be selected by default (null for none),
                        // and the listener through which to receive callbacks when items are selected
                        .setMultiChoiceItems(R.array.suitability_profiles,
                                isSelected,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        which++;
                                        if (isChecked) {
                                            // If the user checked the item, add it to the selected items
                                            mFilterSelectedItems.add(which);
                                        } else if (mFilterSelectedItems.contains(which)) {
                                            // Else, if the item is already in the array, remove it
                                            mFilterSelectedItems.remove(Integer.valueOf(which));
                                        }
                                    }
                                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mPresenter.setSuitabilityFilter(mFilterSelectedItems);
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        mAdapter = new FundListAdapter(new FundListItemViewHolder.OnListItemClick() {
            @Override
            public void displayInfo(Fund fund) {
                Toast.makeText(getContext(), "Info " + fund.getSimpleName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void displayInvest(Fund fund) {
                Toast.makeText(getContext(), "Invest " + fund.getSimpleName(), Toast.LENGTH_SHORT).show();
            }
        });
        mAdapter.setHasStableIds(true);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void displayError() {
        mLoadingView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        mEmptyView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void displayEmptyList() {
        mLoadingView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
        mEmptyView.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void setListItems(List<Fund> funds) {
        mLoadingView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
        mEmptyView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);

        mAdapter.setListItems(funds);
    }
}