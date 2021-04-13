package com.tiagosgomes.desafioorama.presentation.fund.list;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.tiagosgomes.desafioorama.R;
import com.tiagosgomes.desafioorama.domain.Fund;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FundListItemViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;

    private OnListItemClick mOnClickListener;

    private Fund mFund;

    @BindView(R.id.fund_list_item_sustainability)
    View sustainability;

    @BindView(R.id.fund_list_item_title)
    TextView title;

    @BindView(R.id.fund_list_item_type)
    TextView type;

    @BindView(R.id.fund_list_item_tax_class)
    TextView taxClass;

    @BindView(R.id.fund_list_item_retrieval_days)
    TextView retrievalDays;

    @BindView(R.id.fund_list_item_initial_capital)
    TextView initialCapital;

    @BindView(R.id.fund_list_item_profitability)
    TextView profitability;

    @BindView(R.id.fund_list_item_info_button)
    Button infoButton;

    @BindView(R.id.fund_list_item_invest_button)
    Button investButton;

    public interface OnListItemClick {
        void displayInfo(Fund fund);


        void displayInvest(Fund fund);
    }

    FundListItemViewHolder(View itemView, OnListItemClick onClick) {
        super(itemView);

        mContext = itemView.getContext();

        mOnClickListener = onClick;

        ButterKnife.bind(this, itemView);
    }

    void bind(Fund fund) {
        mFund = fund;

        int color;
        if (fund.getSuitabilityProfile() == 1) {
            color = ContextCompat.getColor(mContext, R.color.green);
        } else if (fund.getSuitabilityProfile() == 2) {
            color = ContextCompat.getColor(mContext, R.color.yellow);
        } else // ( fund.getSuitabilityProfile() == 3 ) == true
        {
            color = ContextCompat.getColor(mContext, R.color.red);
        }
        sustainability.setBackgroundColor(color);

        title.setText(fund.getSimpleName());

        type.setText(fund.getType());

        taxClass.setText(fund.getTaxClassification());

        String retrievalDaysString = "D + " + fund.getRetrievalLiquidationDays();
        retrievalDays.setText(retrievalDaysString);

        Locale ptBr = new Locale("pt", "BR");
        String value = NumberFormat.getCurrencyInstance(ptBr).format(fund.getMinInitialApplicationAmount());
        initialCapital.setText(value);

        String profitabilityText;

        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(2);

        if (fund.getProfitabilities().get("year") != null) {
            String percent = percentFormat.format(Float.parseFloat(fund.getProfitabilities().get("year")));
            profitabilityText = Calendar.getInstance().get(Calendar.YEAR) + " " + percent;
        } else {
            profitabilityText = " - ";
        }
        profitability.setText(profitabilityText);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.displayInfo(mFund);
            }
        });

        investButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.displayInvest(mFund);
            }
        });
    }
}