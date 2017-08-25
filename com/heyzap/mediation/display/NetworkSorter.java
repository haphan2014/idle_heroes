package com.heyzap.mediation.display;

import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.internal.LargeSet;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.adapter.AdapterPool;
import com.heyzap.mediation.display.DisplayConfig.Network;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NetworkSorter {
    public void sortNetworks(List<Network> networks, final AdapterPool adapterPool, final DisplayOptions baseDisplayOptions) {
        Collections.sort(networks, Collections.reverseOrder(new Comparator<Network>() {
            public int compare(Network networkOne, Network networkTwo) {
                NetworkAdapter adapterOne = adapterPool.get(networkOne.network);
                NetworkAdapter adapterTwo = adapterPool.get(networkTwo.network);
                if (adapterOne == adapterTwo) {
                    return 0;
                }
                if (adapterOne == null) {
                    return 1;
                }
                if (adapterTwo == null) {
                    return -1;
                }
                return Double.valueOf(Math.max(networkOne.getScore().doubleValue(), adapterOne.getScoreOverride(DisplayOptions.builder(baseDisplayOptions.getAdUnit()).setTag(baseDisplayOptions.getTag()).setNetworks(baseDisplayOptions.getNetworks()).setCreativeTypes(LargeSet.of(networkOne.creativeType)).build()).doubleValue())).compareTo(Double.valueOf(Math.max(networkTwo.getScore().doubleValue(), adapterTwo.getScoreOverride(DisplayOptions.builder(baseDisplayOptions.getAdUnit()).setTag(baseDisplayOptions.getTag()).setNetworks(baseDisplayOptions.getNetworks()).setCreativeTypes(LargeSet.of(networkTwo.creativeType)).build()).doubleValue())));
            }
        }));
    }
}
