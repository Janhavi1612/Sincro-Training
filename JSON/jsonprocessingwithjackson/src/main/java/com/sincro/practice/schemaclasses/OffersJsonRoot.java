package com.sincro.practice.schemaclasses;

import java.util.List;

public class OffersJsonRoot {
    private Meta meta;
    private PaginationInfo paginationInfo;
    private List<Offer> offers;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
