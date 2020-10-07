package com.sincro.practice.offer;

import java.util.List;

class Offer {
    private String createdBy;
    private long createdDate;
    private String modifiedBy;
    private long modifiedDate;
    private int id;
    private String title;
    private String description;
    private String disclaimer;
    private List<Integer> stackableOffers;
    private String startDate;
    private String endDate;
    private Detail detail;
    public List<Criterion> criteria;
    private VehicleCriteria vehicleCriteria;
    private ClientConfiguration clientConfiguration;
    private String subtitle;
    private ExternalOffer externalOffer;
    private Info info;
    private Participation participation;
    private boolean forceActive;
    private String offerSourceType;
    private String programId;
    private Owner owner;


    public class Detail {
        private String type;
        private List<Object> cashComponents;
        private List<String> purchaseTypes;
        private PurchaseTypesDetail purchaseTypesDetail;
        private List<Object> terms;
        private double amount;
        private String priceType;
        private boolean termSupportAvailable;
        private String label;
        private boolean mileageSupportAvailable;

        public class PurchaseTypesDetail {
            private List<String> available;
            private List<String> applicable;

            public List<String> getAvailable() {
                return available;
            }

            public void setAvailable(List<String> available) {
                this.available = available;
            }

            public List<String> getApplicable() {
                return applicable;
            }

            public void setApplicable(List<String> applicable) {
                this.applicable = applicable;
            }
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Object> getCashComponents() {
            return cashComponents;
        }

        public void setCashComponents(List<Object> cashComponents) {
            this.cashComponents = cashComponents;
        }

        public List<String> getPurchaseTypes() {
            return purchaseTypes;
        }

        public void setPurchaseTypes(List<String> purchaseTypes) {
            this.purchaseTypes = purchaseTypes;
        }

        public PurchaseTypesDetail getPurchaseTypesDetail() {
            return purchaseTypesDetail;
        }

        public void setPurchaseTypesDetail(PurchaseTypesDetail purchaseTypesDetail) {
            this.purchaseTypesDetail = purchaseTypesDetail;
        }

        public List<Object> getTerms() {
            return terms;
        }

        public void setTerms(List<Object> terms) {
            this.terms = terms;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getPriceType() {
            return priceType;
        }

        public void setPriceType(String priceType) {
            this.priceType = priceType;
        }

        public boolean isTermSupportAvailable() {
            return termSupportAvailable;
        }

        public void setTermSupportAvailable(boolean termSupportAvailable) {
            this.termSupportAvailable = termSupportAvailable;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public boolean isMileageSupportAvailable() {
            return mileageSupportAvailable;
        }

        public void setMileageSupportAvailable(boolean mileageSupportAvailable) {
            this.mileageSupportAvailable = mileageSupportAvailable;
        }
    }

    public class ClientConfiguration {
        private CustomConfigurations customConfigurations;

        public class CustomConfigurations {
            private String institutionsList;
            private String dealGroup;
            private String programInfoUrl;
            private String flexibleCriteriaRelation;
            private String groupAffiliation;
            private String programAbbrCode;
            private String customerTypeCodes;
            private String customerTypes;
            private String previousOwnership;

            public String getInstitutionsList() {
                return institutionsList;
            }

            public void setInstitutionsList(String institutionsList) {
                this.institutionsList = institutionsList;
            }

            public String getDealGroup() {
                return dealGroup;
            }

            public void setDealGroup(String dealGroup) {
                this.dealGroup = dealGroup;
            }

            public String getProgramInfoUrl() {
                return programInfoUrl;
            }

            public void setProgramInfoUrl(String programInfoUrl) {
                this.programInfoUrl = programInfoUrl;
            }

            public String getFlexibleCriteriaRelation() {
                return flexibleCriteriaRelation;
            }

            public void setFlexibleCriteriaRelation(String flexibleCriteriaRelation) {
                this.flexibleCriteriaRelation = flexibleCriteriaRelation;
            }

            public String getGroupAffiliation() {
                return groupAffiliation;
            }

            public void setGroupAffiliation(String groupAffiliation) {
                this.groupAffiliation = groupAffiliation;
            }

            public String getProgramAbbrCode() {
                return programAbbrCode;
            }

            public void setProgramAbbrCode(String programAbbrCode) {
                this.programAbbrCode = programAbbrCode;
            }

            public String getCustomerTypeCodes() {
                return customerTypeCodes;
            }

            public void setCustomerTypeCodes(String customerTypeCodes) {
                this.customerTypeCodes = customerTypeCodes;
            }

            public String getCustomerTypes() {
                return customerTypes;
            }

            public void setCustomerTypes(String customerTypes) {
                this.customerTypes = customerTypes;
            }

            public String getPreviousOwnership() {
                return previousOwnership;
            }

            public void setPreviousOwnership(String previousOwnership) {
                this.previousOwnership = previousOwnership;
            }
        }

        public CustomConfigurations getCustomConfigurations() {
            return customConfigurations;
        }

        public void setCustomConfigurations(CustomConfigurations customConfigurations) {
            this.customConfigurations = customConfigurations;
        }
    }

    public class ExternalOffer {
        private String externalSourceOfferId;
        private String offerSourceName;

        public String getExternalSourceOfferId() {
            return externalSourceOfferId;
        }

        public void setExternalSourceOfferId(String externalSourceOfferId) {
            this.externalSourceOfferId = externalSourceOfferId;
        }

        public String getOfferSourceName() {
            return offerSourceName;
        }

        public void setOfferSourceName(String offerSourceName) {
            this.offerSourceName = offerSourceName;
        }
    }

    public class Info {
        private int offerId;
        private String participation;
        private boolean participationChangeAllowed;
        private boolean promotedByOEM;
        private boolean splitOffer;
        private boolean attachToInventory;
        private boolean shareOfferWithOtherDealer;
        private boolean featured;

        public int getOfferId() {
            return offerId;
        }

        public void setOfferId(int offerId) {
            this.offerId = offerId;
        }

        public String getParticipation() {
            return participation;
        }

        public void setParticipation(String participation) {
            this.participation = participation;
        }

        public boolean isParticipationChangeAllowed() {
            return participationChangeAllowed;
        }

        public void setParticipationChangeAllowed(boolean participationChangeAllowed) {
            this.participationChangeAllowed = participationChangeAllowed;
        }

        public boolean isPromotedByOEM() {
            return promotedByOEM;
        }

        public void setPromotedByOEM(boolean promotedByOEM) {
            this.promotedByOEM = promotedByOEM;
        }

        public boolean isSplitOffer() {
            return splitOffer;
        }

        public void setSplitOffer(boolean splitOffer) {
            this.splitOffer = splitOffer;
        }

        public boolean isAttachToInventory() {
            return attachToInventory;
        }

        public void setAttachToInventory(boolean attachToInventory) {
            this.attachToInventory = attachToInventory;
        }

        public boolean isShareOfferWithOtherDealer() {
            return shareOfferWithOtherDealer;
        }

        public void setShareOfferWithOtherDealer(boolean shareOfferWithOtherDealer) {
            this.shareOfferWithOtherDealer = shareOfferWithOtherDealer;
        }

        public boolean isFeatured() {
            return featured;
        }

        public void setFeatured(boolean featured) {
            this.featured = featured;
        }
    }

    public class Participation {
        private String defaultParticipation;
        private String overriddenParticipation;
        private String overridingSource;

        public String getDefaultParticipation() {
            return defaultParticipation;
        }

        public void setDefaultParticipation(String defaultParticipation) {
            this.defaultParticipation = defaultParticipation;
        }

        public String getOverriddenParticipation() {
            return overriddenParticipation;
        }

        public void setOverriddenParticipation(String overriddenParticipation) {
            this.overriddenParticipation = overriddenParticipation;
        }

        public String getOverridingSource() {
            return overridingSource;
        }

        public void setOverridingSource(String overridingSource) {
            this.overridingSource = overridingSource;
        }
    }

    public class Owner {
        private String ownerReferenceKey;
        private String locale;

        public String getOwnerReferenceKey() {
            return ownerReferenceKey;
        }

        public void setOwnerReferenceKey(String ownerReferenceKey) {
            this.ownerReferenceKey = ownerReferenceKey;
        }

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public List<Integer> getStackableOffers() {
        return stackableOffers;
    }

    public void setStackableOffers(List<Integer> stackableOffers) {
        this.stackableOffers = stackableOffers;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<Criterion> criteria) {
        this.criteria = criteria;
    }

    public VehicleCriteria getVehicleCriteria() {
        return vehicleCriteria;
    }

    public void setVehicleCriteria(VehicleCriteria vehicleCriteria) {
        this.vehicleCriteria = vehicleCriteria;
    }

    public ClientConfiguration getClientConfiguration() {
        return clientConfiguration;
    }

    public void setClientConfiguration(ClientConfiguration clientConfiguration) {
        this.clientConfiguration = clientConfiguration;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public ExternalOffer getExternalOffer() {
        return externalOffer;
    }

    public void setExternalOffer(ExternalOffer externalOffer) {
        this.externalOffer = externalOffer;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Participation getParticipation() {
        return participation;
    }

    public void setParticipation(Participation participation) {
        this.participation = participation;
    }

    public boolean isForceActive() {
        return forceActive;
    }

    public void setForceActive(boolean forceActive) {
        this.forceActive = forceActive;
    }

    public String getOfferSourceType() {
        return offerSourceType;
    }

    public void setOfferSourceType(String offerSourceType) {
        this.offerSourceType = offerSourceType;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
