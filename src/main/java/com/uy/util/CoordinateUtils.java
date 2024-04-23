package com.uy.util;

public class CoordinateUtils {

    private static final double EARTH_RADIUS = 6371; // 地球的半径，单位：公里

    /**
     * 判断当前坐标是否在指定范围内
     * @param currentLongitude 当前位置的经度
     * @param currentLatitude 当前位置的纬度
     * @param targetLongitude 目标位置的经度
     * @param targetLatitude 目标位置的纬度
     * @param range 接受范围
     *
     */
    public static boolean isWithinRange(double currentLongitude, double currentLatitude,
                                        double targetLongitude, double targetLatitude,
                                        double range) {
        double distance = calculateDistance(currentLongitude, currentLatitude, targetLongitude, targetLatitude);

        return distance <= range;
    }

    /**
     * 计算两个坐标之间的距离
     * @param lon1 第一个坐标的经度
     * @param lat1 第一个坐标的纬度
     * @param lon2 第二个坐标的经度
     * @param lat2 第二个坐标的纬度
     * @return 距离（单位：公里）
     */
    public static double calculateDistance(double lon1, double lat1, double lon2, double lat2) {
        double lon1Rad = Math.toRadians(lon1);
        double lat1Rad = Math.toRadians(lat1);
        double lon2Rad = Math.toRadians(lon2);
        double lat2Rad = Math.toRadians(lat2);

        double lonDiff = lon2Rad - lon1Rad;
        double latDiff = lat2Rad - lat1Rad;

        double a = Math.sin(latDiff/2) * Math.sin(latDiff/2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(lonDiff/2) * Math.sin(lonDiff/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return EARTH_RADIUS * c;
    }

}
