package com.heyzap.mediation.abstr;

import com.heyzap.internal.Logger;
import com.heyzap.mediation.abstr.NetworkAdapter.ConfigurationError;
import com.heyzap.mediation.adapter.AdapterConfiguration;

public class NetworkAdapterFactory {
    public static NetworkAdapter build(AdapterConfiguration config) throws ConfigurationError {
        String adapterClassName = config.getAdapterClassName();
        if (adapterClassName == null) {
            try {
                throw new ClassNotFoundException("No adapter class name provided.");
            } catch (Throwable e) {
                Logger.trace(e);
                throw new ConfigurationError("No adapter available or network classes not onboard.");
            } catch (Throwable e2) {
                Logger.trace(e2);
                throw new ConfigurationError("No adapter available or network classes not onboard.");
            } catch (Throwable e22) {
                Logger.trace(e22);
                throw new ConfigurationError("No adapter available or network classes not onboard.");
            } catch (Throwable e222) {
                Logger.trace(e222);
                throw new ConfigurationError("No adapter available or network classes not onboard.");
            } catch (Throwable e2222) {
                Logger.trace(e2222);
                throw new ConfigurationError("No adapter available or network classes not onboard.");
            } catch (Throwable e22222) {
                Logger.trace(e22222);
                throw new ConfigurationError("No adapter available or network classes not onboard.");
            }
        }
        return (NetworkAdapter) Class.forName(adapterClassName).getConstructor(new Class[]{AdapterConfiguration.class}).newInstance(new Object[]{config});
    }
}
