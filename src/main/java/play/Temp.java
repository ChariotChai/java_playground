package play;

import java.util.Arrays;

public class Temp {

    private static long genHighOrderWithSharding(long orderId, String district) {
        int districtInt = Integer.valueOf(district);

        String bid = Long.toBinaryString(orderId);
        char[] cs = new char[64 - bid.length()];
        Arrays.fill(cs, '0');
        bid = new String(cs) + bid;

        System.out.println("bid:" + bid);

        String high18OrderId = bid.substring(0, 18); // 订单高18位
        String midb22OrderId = bid.substring(18, 40); //订单中22位
        String low9OrderId = bid.substring(40, 49);    //订单低9位


        long shigh18OrderId = Long.valueOf(high18OrderId, 2);
        long smidb22OrderId = Long.valueOf(midb22OrderId, 2);
        long slow9OrderId = Long.valueOf(low9OrderId, 2);

        long iLow = 0x1FF & slow9OrderId;
        long iFixed = (1 << 9);
        long iMiddle = (0x3FFFFF & smidb22OrderId) << 10;
        long iShardingShift = (0x3FFF & districtInt) << 32;
        long iHigh = (0x3FFFF & shigh18OrderId) << 46;
        long iNewOid = iHigh | iShardingShift | iMiddle | iFixed | iLow;
        return iNewOid;

    }

    public static void main(String[] args) {
        System.out.println(genHighOrderWithSharding(17667881471359L, "123"));
    }

}
