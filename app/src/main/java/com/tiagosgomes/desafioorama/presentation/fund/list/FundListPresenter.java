package com.tiagosgomes.desafioorama.presentation.fund.list;

import androidx.annotation.NonNull;

import com.tiagosgomes.desafioorama.data.ApiService;
import com.tiagosgomes.desafioorama.data.ApiUtils;
import com.tiagosgomes.desafioorama.domain.Fund;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FundListPresenter implements FundListContract.Presenter {

    private FundListContract.View mView;

    private List<Fund> mFunds;
    private List<Fund> mFilteredFunds;

    FundListPresenter(FundListContract.View view) {
        mView = view;

        ApiService apiService = ApiUtils.getInstance();
        apiService.getFunds().enqueue(new Callback<List<Fund>>() {
            @Override
            public void onResponse(@NonNull Call<List<Fund>> call, @NonNull Response<List<Fund>> response) {
                if (response.body() != null) {
                    mFunds = response.body();
                    mFilteredFunds = new ArrayList<>(mFunds);

                    displayList();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Fund>> call, @NonNull Throwable t) {
                mView.displayError();
            }
        });
    }

    @Override
    public void setSuitabilityFilter(List<Integer> suitability) {
        mFilteredFunds = new ArrayList<>(mFunds);

        for (int i = mFunds.size() - 1; i >= 0; i--) {
            boolean contained = false;

            for (int j = 0; j < suitability.size(); j++) {
                if (mFunds.get(i).getSuitabilityProfile() == suitability.get(j)) {
                    contained = true;
                }
            }

            if (!contained) {
                mFilteredFunds.remove(i);
            }
        }

        displayList();
    }

    private void displayList() {
        if (mFilteredFunds.size() > 0) {
            mView.setListItems(mFilteredFunds);
        } else {
            mView.displayEmptyList();
        }
    }
}