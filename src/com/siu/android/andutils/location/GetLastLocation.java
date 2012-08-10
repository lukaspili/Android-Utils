package com.siu.android.andutils.location;

import android.location.Location;
import android.location.LocationListener;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public interface GetLastLocation {

    /**
     * Find the most accurate and timely previously detected location
     * using all the location providers. Where the last result is beyond
     * the acceptable maximum distance or latency create a one-shot update
     * of the current location to be returned using the {@link android.location.LocationListener}
     * passed in through {@link setChangedLocationListener}
     * @param minDistance Minimum distance before we require a location update.
     * @param minTime Minimum time required between location updates.
     * @return The most accurate and / or timely previously detected location.
     */
    public Location getLastBestLocation(int minDistance, long minTime);

    /**
     * Set the {@link android.location.LocationListener} that may receive a one-shot current location update.
     * @param l LocationListener
     */
    public void setChangedLocationListener(LocationListener l);

    /**
     * Cancel the one-shot current location update.
     */
    public void cancel();

}
