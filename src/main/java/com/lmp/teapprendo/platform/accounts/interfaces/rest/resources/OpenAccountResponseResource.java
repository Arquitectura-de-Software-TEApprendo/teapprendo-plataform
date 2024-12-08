package com.lmp.teapprendo.platform.accounts.interfaces.rest.resources;

import com.lmp.teapprendo.platform.shared.domain.model.valueobjects.Error;
import java.util.List;

public record OpenAccountResponseResource(
        AccountResource success,
        List<Error> errors
) {}
