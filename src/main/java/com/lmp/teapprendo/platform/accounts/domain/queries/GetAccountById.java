package com.lmp.teapprendo.platform.accounts.domain.queries;

import lombok.Value;

@Value
public class GetAccountById {
    private final Long id;

    public GetAccountById(Long id) {
        this.id = id;
    }
}
