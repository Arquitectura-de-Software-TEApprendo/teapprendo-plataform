package com.lmp.teapprendo.platform.accounts.interfaces.rest.resources;

import com.lmp.teapprendo.platform.shared.domain.model.valueobjects.Error;
import java.util.List;

public record EditAccountResponseResource(
        AccountEditedResource success,
        List<Error> errors
) {}
