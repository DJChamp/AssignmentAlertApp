package com.example.android.assignmentalertapp;

import android.provider.BaseColumns;

/**
 * Created by Montya on 22-10-2015.
 */
public class TableData {

    TableData() {

    }

    public static abstract class Tableinfo implements BaseColumns {
        public static final String ASSIGNMENT_TITLE = "assignment_title";
        public static final String ASSIGNMENT_INFO = "assignment_info";
        public static final String ASSIGNMENT_END_DATE = "assignment_end_date";
        public static final String ASSIGNMENT_TIME = "assignment_time";
        public static final String ASSIGNMENT_ALARM_NUM = "assignment_alarm_num";
        public static final String TABLE_NAME_1 = "table1";
        public static final String TABLE_NAME_2 = "table2";
        public static final String TABLE_NAME_3 = "table3";
        public static final String TABLE_NAME_4 = "table4";
        public static final String TABLE_NAME_5 = "table5";
        public static final String TABLE_NAME_6 = "table6";
        public static final String TABLE_NAME_7 = "table7";
        public static final String TABLE_NAME_8 = "table8";
        public static final String TABLE_NAME_9 = "table9";
        public static final String TABLE_NAME_10 = "table10";
        public static final String TABLE_NAME_SUB = "subject_table";
        public static final String SUBJECT_NAMES = "subject_names";
        public static final String DATABASE_NAME = "assignment_database";

        public static String getTableName(int table) {
            String table_name = "";
            switch (table) {
                case 1:
                    table_name = TABLE_NAME_1;
                    break;
                case 2:
                    table_name = TABLE_NAME_2;
                    break;
                case 3:
                    table_name = TABLE_NAME_3;
                    break;
                case 4:
                    table_name = TABLE_NAME_4;
                    break;
                case 5:
                    table_name = TABLE_NAME_5;
                    break;
                case 6:
                    table_name = TABLE_NAME_6;
                    break;
                case 7:
                    table_name = TABLE_NAME_7;
                    break;
                case 8:
                    table_name = TABLE_NAME_8;
                    break;
                case 9:
                    table_name = TABLE_NAME_9;
                    break;
                case 10:
                    table_name = TABLE_NAME_10;
                    break;
                default:
                    table_name = TABLE_NAME_1;
            }
            return table_name;
        }
    }

}
