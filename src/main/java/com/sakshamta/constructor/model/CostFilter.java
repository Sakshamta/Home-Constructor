package com.sakshamta.constructor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CostFilter {

    private Long minEstimatedCost = (long)0;
    private Long maxEstimatedCost = (long)0;
}
