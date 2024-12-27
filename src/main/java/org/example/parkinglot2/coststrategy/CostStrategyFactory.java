package org.example.parkinglot2.coststrategy;

import org.example.parkinglot2.SpotType;

import java.util.EnumMap;
import java.util.Map;

public class CostStrategyFactory {

    private static final Map<SpotType,CostStrategy > strategyMap = new EnumMap<>(SpotType.class);

    static {
        strategyMap.put(SpotType.COMPACT, new CarCostCalculator());
        strategyMap.put(SpotType.LARGE, new TruckCostCalculator());
    }

    public static CostStrategy getStrategy(SpotType spotType){
        return strategyMap.getOrDefault(spotType, ticket -> 0.0);
    }
}
