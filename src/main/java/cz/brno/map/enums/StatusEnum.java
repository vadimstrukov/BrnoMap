package cz.brno.map.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by strukov on 7/21/16.
 */
public enum StatusEnum {

    NA(0, "N/A"),
    SEASON_OVER(1, "Season is over"),
    CLOSED(2, "Closed"),
    CLOSED_WEATHER(3, "Closed because of weather conditions"),
    CLOSED_LIFT_OPEN(4, "Closed, lift open"),
    CLOSED_NORDIC_OPEN(5, "Closed, nordic walking trails open"),
    TEMPORARY_CLOSED(6, "Temporary closed"),
    OPEN_INTEREST(7, "Open according to interest"),
    OPEN_WEEKENDS(8, "Open during weekends"),
    NIGHT_SKIING(9, "Night skiing"),
    PARTIAL_OPEN(10, " Partial open"),
    OPEN(11, "Open"),
    CLOSED_RESTAURANT_OPEN(12, "Closed, restaurant open"),
    CLOSED_BOBSLEDGE_OPEN(13, " Closed, bobsledge open"),
    OPEN_SUMMER(14, "Open during summer season");

    @Getter @Setter
    private int statusCode;
    @Getter @Setter
    private String statusText;


    StatusEnum(int statusCode, String statusText){
        this.statusCode = statusCode;
        this.statusText = statusText;
    }

}
