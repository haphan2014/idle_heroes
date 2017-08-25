package com.heyzap.mediation.adapter;

import com.heyzap.internal.Constants.AdUnit;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AdUnitAliasMap {
    private final Map<AdUnit, AdUnit> aliasMap = new ConcurrentHashMap();

    public void add(AdUnit alias, AdUnit internalUnit) {
        this.aliasMap.put(alias, internalUnit);
    }

    public AdUnit translate(AdUnit alias) {
        AdUnit retUnit = (AdUnit) this.aliasMap.get(alias);
        if (retUnit == null) {
            return alias;
        }
        return retUnit;
    }

    public Set<AdUnit> translate(Collection<AdUnit> adUnits) {
        Set<AdUnit> retmap = new HashSet();
        for (AdUnit adUnit : adUnits) {
            retmap.add(translate(adUnit));
        }
        return retmap;
    }

    public Set<AdUnit> getAliases(AdUnit adUnit) {
        Set<AdUnit> adUnits = new HashSet();
        adUnits.add(adUnit);
        for (Entry<AdUnit, AdUnit> entry : this.aliasMap.entrySet()) {
            if (((AdUnit) entry.getValue()).equals(adUnit)) {
                adUnits.add(entry.getKey());
            }
        }
        return adUnits;
    }
}
