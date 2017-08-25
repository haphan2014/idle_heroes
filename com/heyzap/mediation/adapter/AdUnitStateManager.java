package com.heyzap.mediation.adapter;

import com.heyzap.internal.Constants.AdUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class AdUnitStateManager {
    private AdUnitAliasMap aliasMap = new AdUnitAliasMap();
    private Set<AdUnit> startedUnits = Collections.synchronizedSet(EnumSet.noneOf(AdUnit.class));

    public boolean isStarted(AdUnit adUnit) {
        return this.startedUnits.contains(this.aliasMap.translate(adUnit));
    }

    public boolean allStarted(Collection<AdUnit> unitsToCheck) {
        for (AdUnit unit : unitsToCheck) {
            if (!isStarted(this.aliasMap.translate(unit))) {
                return false;
            }
        }
        return true;
    }

    public Set<AdUnit> start(Collection<AdUnit> adUnitsToStart) {
        Set<AdUnit> newlyStartedUnits = new HashSet();
        for (AdUnit adUnit : adUnitsToStart) {
            AdUnit internalUnit = this.aliasMap.translate(adUnit);
            if (this.startedUnits.add(internalUnit)) {
                newlyStartedUnits.add(internalUnit);
            }
        }
        return newlyStartedUnits;
    }

    public void setAliasMap(AdUnitAliasMap aliasMap) {
        this.aliasMap = aliasMap;
    }
}
