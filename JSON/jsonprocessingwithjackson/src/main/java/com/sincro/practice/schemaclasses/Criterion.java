package com.sincro.practice.schemaclasses;

import java.util.List;

public class Criterion {
        private String type;
        String createdBy;
        private String modifiedBy;
        private int offerId;
        private String excludeCriteria;
        private CriteriaMap criteriaMap;
        private String overrideCriteria;
        private List<Object> vins;
        private List<Object> types;
        private List<String> years;
        private List<String> makes;
        private List<String> models;
        private List<Object> modelCodes;
        private List<Object> trims;
        private List<Object> series;
        private List<Object> stockNums;
        private String category;
        private List<Object> priceCriteria;
        private List<Object> cobaltStyleId;
        private List<Object> modelYears;
        private List<OfferFlexibleCriteria> offerFlexibleCriterias;
        private boolean exclude;
        private boolean override;
        private FlexibleCriteriaMap flexibleCriteriaMap;

        public class CriteriaMap { }



        public class FlexibleCriteriaMap {
            private County county;
            private State state;

            public class County {
                private String key;
                private List<String> includes;
                private List<Object> excludes;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public List<String> getIncludes() {
                    return includes;
                }

                public void setIncludes(List<String> includes) {
                    this.includes = includes;
                }

                public List<Object> getExcludes() {
                    return excludes;
                }

                public void setExcludes(List<Object> excludes) {
                    this.excludes = excludes;
                }
            }

            public class State {
                private String key;
                private List<String> includes;
                private List<Object> excludes;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public List<String> getIncludes() {
                    return includes;
                }

                public void setIncludes(List<String> includes) {
                    this.includes = includes;
                }

                public List<Object> getExcludes() {
                    return excludes;
                }

                public void setExcludes(List<Object> excludes) {
                    this.excludes = excludes;
                }
            }

            public FlexibleCriteriaMap.County getCounty() {
                return county;
            }

            public void setCounty(FlexibleCriteriaMap.County county) {
                this.county = county;
            }

            public FlexibleCriteriaMap.State getState() {
                return state;
            }

            public void setState(FlexibleCriteriaMap.State state) {
                this.state = state;
            }
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getModifiedBy() {
            return modifiedBy;
        }

        public void setModifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
        }

        public int getOfferId() {
            return offerId;
        }

        public void setOfferId(int offerId) {
            this.offerId = offerId;
        }

        public String getExcludeCriteria() {
            return excludeCriteria;
        }

        public void setExcludeCriteria(String excludeCriteria) {
            this.excludeCriteria = excludeCriteria;
        }

        public CriteriaMap getCriteriaMap() {
            return criteriaMap;
        }

        public void setCriteriaMap(CriteriaMap criteriaMap) {
            this.criteriaMap = criteriaMap;
        }

        public String getOverrideCriteria() {
            return overrideCriteria;
        }

        public void setOverrideCriteria(String overrideCriteria) {
            this.overrideCriteria = overrideCriteria;
        }

        public List<Object> getVins() {
            return vins;
        }

        public void setVins(List<Object> vins) {
            this.vins = vins;
        }

        public List<Object> getTypes() {
            return types;
        }

        public void setTypes(List<Object> types) {
            this.types = types;
        }

        public List<String> getYears() {
            return years;
        }

        public void setYears(List<String> years) {
            this.years = years;
        }

        public List<String> getMakes() {
            return makes;
        }

        public void setMakes(List<String> makes) {
            this.makes = makes;
        }

        public List<String> getModels() {
            return models;
        }

        public void setModels(List<String> models) {
            this.models = models;
        }

        public List<Object> getModelCodes() {
            return modelCodes;
        }

        public void setModelCodes(List<Object> modelCodes) {
            this.modelCodes = modelCodes;
        }

        public List<Object> getTrims() {
            return trims;
        }

        public void setTrims(List<Object> trims) {
            this.trims = trims;
        }

        public List<Object> getSeries() {
            return series;
        }

        public void setSeries(List<Object> series) {
            this.series = series;
        }

        public List<Object> getStockNums() {
            return stockNums;
        }

        public void setStockNums(List<Object> stockNums) {
            this.stockNums = stockNums;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public List<Object> getPriceCriteria() {
            return priceCriteria;
        }

        public void setPriceCriteria(List<Object> priceCriteria) {
            this.priceCriteria = priceCriteria;
        }

        public List<Object> getCobaltStyleId() {
            return cobaltStyleId;
        }

        public void setCobaltStyleId(List<Object> cobaltStyleId) {
            this.cobaltStyleId = cobaltStyleId;
        }

        public List<Object> getModelYears() {
            return modelYears;
        }

        public void setModelYears(List<Object> modelYears) {
            this.modelYears = modelYears;
        }

        public List<OfferFlexibleCriteria> getOfferFlexibleCriterias() {
            return offerFlexibleCriterias;
        }

        public void setOfferFlexibleCriterias(List<OfferFlexibleCriteria> offerFlexibleCriterias) {
            this.offerFlexibleCriterias = offerFlexibleCriterias;
        }

        public boolean isExclude() {
            return exclude;
        }

        public void setExclude(boolean exclude) {
            this.exclude = exclude;
        }

        public boolean isOverride() {
            return override;
        }

        public void setOverride(boolean override) {
            this.override = override;
        }

        public FlexibleCriteriaMap getFlexibleCriteriaMap() {
            return flexibleCriteriaMap;
        }

        public void setFlexibleCriteriaMap(FlexibleCriteriaMap flexibleCriteriaMap) {
            this.flexibleCriteriaMap = flexibleCriteriaMap;
        }

}
