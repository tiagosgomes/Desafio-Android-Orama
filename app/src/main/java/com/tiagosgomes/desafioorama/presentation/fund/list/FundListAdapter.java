package com.tiagosgomes.desafioorama.presentation.fund.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.tiagosgomes.desafioorama.R;
import com.tiagosgomes.desafioorama.domain.Fund;

import java.util.ArrayList;
import java.util.List;

public class FundListAdapter extends RecyclerView.Adapter<FundListItemViewHolder> {

    private FundListItemViewHolder.OnListItemClick mOnListItemClickListener;

    private List<Fund> mFunds = new ArrayList<>();

    FundListAdapter(FundListItemViewHolder.OnListItemClick onListItemClick) {
        mOnListItemClickListener = onListItemClick;
    }

    void setListItems(List<Fund> funds) {
        applyAndAnimateRemovals(funds);
        applyAndAnimateAdditions(funds);
        applyAndAnimateMovedItems(funds);
    }

    @Override
    public FundListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fund_list_item, parent, false);

        return new FundListItemViewHolder(view, mOnListItemClickListener);
    }

    @Override
    public void onBindViewHolder(FundListItemViewHolder holder, int position) {
        holder.bind(mFunds.get(position));
    }

    @Override
    public int getItemCount() {
        return mFunds.size();
    }

    @Override
    public long getItemId(int position) {
        return mFunds.get(position).getId();
    }

    private void applyAndAnimateRemovals(List<Fund> funds) {
        for (int i = mFunds.size() - 1; i >= 0; i--) {
            boolean found = false;

            for (int j = 0; j < funds.size(); j++) {
                if (mFunds.get(i).getId() == funds.get(j).getId()) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<Fund> newData) {
        for (int i = 0; i < newData.size(); i++) {
            boolean found = false;

            for (int j = 0; j < mFunds.size(); j++) {
                if (newData.get(i).getId() == mFunds.get(j).getId()) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                insertItem(i, newData.get(i));
            }
        }
    }

    private void applyAndAnimateMovedItems(List<Fund> newData) {
        for (int toPosition = newData.size() - 1; toPosition >= 0; toPosition--) {
            int fromPosition = -1;
            for (int i = 0; i < mFunds.size(); i++) {
                if (mFunds.get(i).getId() == newData.get(toPosition).getId()) {
                    fromPosition = i;
                }
            }

            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    private void insertItem(int position, Fund fund) {
        mFunds.add(position, fund);

        notifyItemInserted(position);
    }

    private void removeItem(int position) {
        mFunds.remove(position);

        notifyItemRemoved(position);
    }

    private void moveItem(int fromPosition, int toPosition) {
        Fund fund = mFunds.remove(fromPosition);

        mFunds.add(toPosition, fund);

        notifyItemMoved(fromPosition, toPosition);
    }
}