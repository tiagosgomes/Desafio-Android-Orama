package com.tiagosgomes.desafioorama.domain;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class FundDeserializer implements JsonDeserializer<Fund> {

    @Override
    public Fund deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context )
            throws JsonParseException
    {
        Gson gson = new Gson( );

        Fund fund = gson.fromJson( json, Fund.class );

        JsonObject fundJson = json.getAsJsonObject( );

        JsonObject operabilityJson = fundJson.getAsJsonObject( "operability" );
        fund.setRetrievalLiquidationDays( operabilityJson.get( "retrieval_liquidation_days" ).getAsInt( ) );
        fund.setMinInitialApplicationAmount( operabilityJson.get( "minimum_initial_application_amount" )
                .getAsFloat( ) );
        fund.setMinSubsequentApplicationAmount( operabilityJson.get( "minimum_subsequent_application_amount" )
                .getAsFloat( ) );

        JsonObject feesJson = fundJson.getAsJsonObject( "fees" );
        fund.setAdministrationFee( feesJson.get( "administration_fee" ).getAsString( ) );
        fund.setMaxAdministrationFee( feesJson.get( "maximum_administration_fee" ).getAsString( ) );
        fund.setPerformanceFee( feesJson.get( "performance_fee" ).getAsString( ) );
        fund.setHasAnticipatedRetrieval( feesJson.get( "has_anticipated_retrieval" ).getAsBoolean( ) );
        fund.setAnticipatedRetrievalFee( feesJson.get( "anticipated_retrieval_fee" ).getAsString( ) );

        JsonObject specificationJson = fundJson.getAsJsonObject( "specification" );
        JsonObject suitabilityProfileJson = specificationJson.getAsJsonObject( "fund_suitability_profile" );
        JsonObject macroStrategyJson = specificationJson.getAsJsonObject( "fund_macro_strategy" );
        JsonObject mainStrategyJson = specificationJson.getAsJsonObject( "fund_main_strategy" );
        fund.setType( specificationJson.get( "fund_type" ).getAsString( ) );
        fund.setFundClass( specificationJson.get( "fund_class" ).getAsString( ) );
        fund.setSuitabilityProfile( suitabilityProfileJson.get( "score_range_order" ).getAsInt( ) );
        fund.setSuitabilityProfileName( suitabilityProfileJson.get( "name" ).getAsString( ) );
        fund.setMacroStrategy( macroStrategyJson.get( "explanation" ).getAsString( ) );
        fund.setMainStrategy( mainStrategyJson.get( "explanation" ).getAsString( ) );

        JsonObject descriptionJson = fundJson.getAsJsonObject( "description" );
        fund.setObjective( descriptionJson.get( "objective" ).getAsString( ) );
        fund.setTargetAudience( descriptionJson.get( "target_audience" ).getAsString( ) );
        fund.setStrengths( descriptionJson.get( "strengths" ).getAsString( ) );
        fund.setStrategy( descriptionJson.get( "strategy" ).getAsString( ) );

        JsonObject fundManagerJson = fundJson.getAsJsonObject( "fund_manager" );
        fund.setFundManagerName( fundManagerJson.get( "full_name" ).getAsString( ) );
        fund.setFundManagerDescription( fundManagerJson.get( "description" ).getAsString( ) );

        return fund;
    }
}
