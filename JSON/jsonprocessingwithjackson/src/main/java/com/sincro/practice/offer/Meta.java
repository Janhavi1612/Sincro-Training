package com.sincro.practice.offer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class Meta {
    private int totalResults;
    private Query query;
    private int responseTime;
    private long lastAccessed;
    private OfferFilters offerFilters;

    public class Query {
        private List<Integer> offerIds;

        public List<Integer> getOfferIds() {
            return offerIds;
        }

        public void setOfferIds(List<Integer> offerIds) {
            this.offerIds = offerIds;
        }
    }

    public class OfferFilters {
        private Categories categories;
        private Offertypes offertypes;

        public class Categories {
            private New _new;

            public class New {
                private String label;
                private int count;
                private Makes makes;
                private Years years;

                public class Makes {
                    @JsonProperty("Chevrolet")
                    public Chevrolet chevrolet;

                    public class Chevrolet {
                        private String label;
                        private int count;
                        private Models models;

                        public class Models {
                            @JsonProperty("Colorado")
                            public Colorado colorado;

                            public class Colorado {
                                public String label;
                                public int count;

                                public String getLabel() {
                                    return label;
                                }

                                public void setLabel(String label) {
                                    this.label = label;
                                }

                                public int getCount() {
                                    return count;
                                }

                                public void setCount(int count) {
                                    this.count = count;
                                }
                            }

                            public Colorado getColorado() {
                                return colorado;
                            }

                            public void setColorado(Colorado colorado) {
                                this.colorado = colorado;
                            }
                        }

                        public String getLabel() {
                            return label;
                        }

                        public void setLabel(String label) {
                            this.label = label;
                        }

                        public int getCount() {
                            return count;
                        }

                        public void setCount(int count) {
                            this.count = count;
                        }

                        public Models getModels() {
                            return models;
                        }

                        public void setModels(Models models) {
                            this.models = models;
                        }
                    }

                    public Chevrolet getChevrolet() {
                        return chevrolet;
                    }

                    public void setChevrolet(Chevrolet chevrolet) {
                        this.chevrolet = chevrolet;
                    }
                }

                public class Years {
                    private TwentyTwenty _2020;

                    public class TwentyTwenty {
                        private String label;
                        private int count;

                        public String getLabel() {
                            return label;
                        }

                        public void setLabel(String label) {
                            this.label = label;
                        }

                        public int getCount() {
                            return count;
                        }

                        public void setCount(int count) {
                            this.count = count;
                        }
                    }

                    public TwentyTwenty get_2020() {
                        return _2020;
                    }

                    public void set_2020(TwentyTwenty _2020) {
                        this._2020 = _2020;
                    }
                }

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public Makes getMakes() {
                    return makes;
                }

                public void setMakes(Makes makes) {
                    this.makes = makes;
                }

                public Years getYears() {
                    return years;
                }

                public void setYears(Years years) {
                    this.years = years;
                }
            }

            public New get_new() {
                return _new;
            }

            public void set_new(New _new) {
                this._new = _new;
            }
        }

        public class Offertypes {
            @JsonProperty("Cash")
            private Cash cash;

            public class Cash {
                private String label;
                private int count;

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public Cash getCash() {
                return cash;
            }

            public void setCash(Cash cash) {
                this.cash = cash;
            }
        }

        public Categories getCategories() {
            return categories;
        }

        public void setCategories(Categories categories) {
            this.categories = categories;
        }

        public Offertypes getOffertypes() {
            return offertypes;
        }

        public void setOffertypes(Offertypes offertypes) {
            this.offertypes = offertypes;
        }
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public long getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public OfferFilters getOfferFilters() {
        return offerFilters;
    }

    public void setOfferFilters(OfferFilters offerFilters) {
        this.offerFilters = offerFilters;
    }
}
