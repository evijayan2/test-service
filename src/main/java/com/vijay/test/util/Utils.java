package com.vijay.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Utils {

	public static String nullCheck(String check) {
        String result = (check != null) ? check : null;
        return result;
    }

    public static String nullCheck(Object check) {
        if (check == null) {
            return null;
        } else {
            if (check instanceof Date) {
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return dt.format(check);
            } else {
                return check.toString();
            }
        }
    }
    
    public static Date nullDateCheck(Object check) {
        if (check == null) {
            return null;
        } else {
            Date date = null;
            if (check instanceof Date) {
                try {
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    date = new Date(dt.parse(dt.format(check)).getTime());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return date;
        }

    }

    public static Long nullLongCheck(Object check) {
        if (check == null) {
            return null;
        } else {
            Long aLong = null;
            if (check instanceof Long) {
                try {
                    aLong = ((Long) check).longValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return aLong;
        }

    }

    public static Integer nullIntegerCheck(Object check) {
        if (check == null) {
            return null;
        } else {
            Integer aInteger = null;
            if (check instanceof Integer) {
                try {
                    aInteger = ((Integer) check).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return aInteger;
        }

    }

    public static Double nullDoubleCheck(Object check) {
        if (check == null) {
            return null;
        } else {
            Double aDouble = null;
            if (check instanceof Double) {
                try {
                    aDouble = ((Double) check).doubleValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return aDouble;
        }

    }

    public static Boolean nullBooleanCheck(Object check) {
        if (check == null) {
            return null;
        } else {
            Boolean aBoolean = false;
            if (check instanceof Boolean) {
                try {
                    aBoolean = ((Boolean) check).booleanValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (check instanceof String) {
                try {
                    aBoolean = Boolean.parseBoolean((String) check);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return aBoolean;
        }

    }

    @SuppressWarnings("unchecked")
	public static List nullListCheck(Object check) {
        List<Map<String, Object>> result = (check != null) ? (List<Map<String, Object>>) check : null;
        return result;
    }

    @SuppressWarnings("unchecked")
	public static List<Map<String, Object>> nullListMapCheck(Object check) {
        List<Map<String, Object>> result = (check != null) ? (List<Map<String, Object>>) check : null;
        return result;
    }

    @SuppressWarnings("unchecked")
	public static Map<String, Object> nullMapCheck(Object check) {
        Map<String, Object> result = (check != null) ? (Map<String, Object>) check : null;
        return result;
    }    
	
}
