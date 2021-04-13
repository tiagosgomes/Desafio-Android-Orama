package com.tiagosgomes.desafioorama.domain;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Fund {

    @SerializedName( "id" )
    private int id;

    @SerializedName( "full_name" )
    private String fullName;

    @SerializedName( "simple_name" )
    private String simpleName;

    @SerializedName( "is_closed" )
    private boolean isClosed;

    @SerializedName( "tax_classification" )
    private String taxClassification;

    @SerializedName( "profitabilities" )
    private Map<String, String> profitabilities;

    /*
     * Operability
     */
    private int   retrievalLiquidationDays;
    private float minInitialApplicationAmount;
    private float minSubsequentApplicationAmount;


    /*
     * Fees
     */
    private String  administrationFee;
    private String  maxAdministrationFee;
    private String  performanceFee;
    private boolean hasAnticipatedRetrieval;
    private String  anticipatedRetrievalFee;

    /*
     * Specification
     */
    private String type;
    private String fundClass;
    private int    suitabilityProfile;
    private String suitabilityProfileName;
    private String macroStrategy;
    private String mainStrategy;

    /*
     * Description
     */
    private String objective;
    private String targetAudience;
    private String strengths;
    private String strategy;

    /*
     * Fund Manager
     */
    private String fundManagerName;
    private String fundManagerDescription;



    public int getId( )
    {
        return id;
    }



    void setId( int id )
    {
        this.id = id;
    }



    public String getFullName( )
    {
        return fullName;
    }



    void setFullName( String fullName )
    {
        this.fullName = fullName;
    }



    public String getSimpleName( )
    {
        return simpleName;
    }



    void setSimpleName( String simpleName )
    {
        this.simpleName = simpleName;
    }



    public boolean isClosed( )
    {
        return isClosed;
    }



    void setClosed( boolean closed )
    {
        isClosed = closed;
    }



    public String getTaxClassification( )
    {
        return taxClassification;
    }



    void setTaxClassification( String taxClassification )
    {
        this.taxClassification = taxClassification;
    }



    public Map<String, String> getProfitabilities( )
    {
        return profitabilities;
    }



    void setProfitabilities( Map<String, String> profitabilities )
    {
        this.profitabilities = profitabilities;
    }



    public int getRetrievalLiquidationDays( )
    {
        return retrievalLiquidationDays;
    }



    void setRetrievalLiquidationDays( int retrievalLiquidationDays )
    {
        this.retrievalLiquidationDays = retrievalLiquidationDays;
    }



    public float getMinInitialApplicationAmount( )
    {
        return minInitialApplicationAmount;
    }



    void setMinInitialApplicationAmount( float minInitialApplicationAmount )
    {
        this.minInitialApplicationAmount = minInitialApplicationAmount;
    }



    public float getMinSubsequentApplicationAmount( )
    {
        return minSubsequentApplicationAmount;
    }



    void setMinSubsequentApplicationAmount( float minSubsequentApplicationAmount )
    {
        this.minSubsequentApplicationAmount = minSubsequentApplicationAmount;
    }



    public String getAdministrationFee( )
    {
        return administrationFee;
    }



    void setAdministrationFee( String administrationFee )
    {
        this.administrationFee = administrationFee;
    }



    public String getMaxAdministrationFee( )
    {
        return maxAdministrationFee;
    }



    void setMaxAdministrationFee( String maxAdministrationFee )
    {
        this.maxAdministrationFee = maxAdministrationFee;
    }



    public String getPerformanceFee( )
    {
        return performanceFee;
    }



    void setPerformanceFee( String performanceFee )
    {
        this.performanceFee = performanceFee;
    }



    public boolean isHasAnticipatedRetrieval( )
    {
        return hasAnticipatedRetrieval;
    }



    void setHasAnticipatedRetrieval( boolean hasAnticipatedRetrieval )
    {
        this.hasAnticipatedRetrieval = hasAnticipatedRetrieval;
    }



    public String getAnticipatedRetrievalFee( )
    {
        return anticipatedRetrievalFee;
    }



    void setAnticipatedRetrievalFee( String anticipatedRetrievalFee )
    {
        this.anticipatedRetrievalFee = anticipatedRetrievalFee;
    }



    public String getType( )
    {
        return type;
    }



    void setType( String type )
    {
        this.type = type;
    }



    public String getFundClass( )
    {
        return fundClass;
    }



    void setFundClass( String fundClass )
    {
        this.fundClass = fundClass;
    }



    public int getSuitabilityProfile( )
    {
        return suitabilityProfile;
    }



    public void setSuitabilityProfile( int suitabilityProfile )
    {
        this.suitabilityProfile = suitabilityProfile;
    }



    public String getSuitabilityProfileName( )
    {
        return suitabilityProfileName;
    }



    public void setSuitabilityProfileName( String suitabilityProfileName )
    {
        this.suitabilityProfileName = suitabilityProfileName;
    }



    public String getMacroStrategy( )
    {
        return macroStrategy;
    }



    void setMacroStrategy( String macroStrategy )
    {
        this.macroStrategy = macroStrategy;
    }



    public String getMainStrategy( )
    {
        return mainStrategy;
    }



    void setMainStrategy( String mainStrategy )
    {
        this.mainStrategy = mainStrategy;
    }



    public String getObjective( )
    {
        return objective;
    }



    void setObjective( String objective )
    {
        this.objective = objective;
    }



    public String getTargetAudience( )
    {
        return targetAudience;
    }



    void setTargetAudience( String targetAudience )
    {
        this.targetAudience = targetAudience;
    }



    public String getStrengths( )
    {
        return strengths;
    }



    void setStrengths( String strengths )
    {
        this.strengths = strengths;
    }



    public String getStrategy( )
    {
        return strategy;
    }



    void setStrategy( String strategy )
    {
        this.strategy = strategy;
    }



    public String getFundManagerName( )
    {
        return fundManagerName;
    }



    void setFundManagerName( String fundManagerName )
    {
        this.fundManagerName = fundManagerName;
    }



    public String getFundManagerDescription( )
    {
        return fundManagerDescription;
    }



    void setFundManagerDescription( String fundManagerDescription )
    {
        this.fundManagerDescription = fundManagerDescription;
    }
}
