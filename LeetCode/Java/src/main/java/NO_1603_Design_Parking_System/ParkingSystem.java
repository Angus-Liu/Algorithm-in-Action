package NO_1603_Design_Parking_System;

/**
 * 设计停车系统
 * https://leetcode-cn.com/problems/design-parking-system/
 */
class ParkingSystem {

    private final int[] parkingSpaces;

    public ParkingSystem(int big, int medium, int small) {
        parkingSpaces = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return parkingSpaces[carType - 1]-- > 0;
    }
}
