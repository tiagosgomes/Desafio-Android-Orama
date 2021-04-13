package com.tiagosgomes.desafioorama.presentation.fund.list;

import com.tiagosgomes.desafioorama.domain.Fund;

import java.util.List;

public interface FundListContract {

    interface View {
        void displayError();

        void displayEmptyList();

        void setListItems(List<Fund> funds);
    }

    interface Presenter {
        void setSuitabilityFilter(List<Integer> suitability);
    }
}