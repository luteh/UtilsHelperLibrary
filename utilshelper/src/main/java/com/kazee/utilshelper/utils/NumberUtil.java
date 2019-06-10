package com.kazee.utilshelper.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

/**
 * Created by wandhie on 8/9/2017.
 */

public class NumberUtil {
    private NumberUtil() {

    }

    public static String bungaDecimal(BigDecimal number) {

        NumberFormat formatter = new DecimalFormat("#0,00");
        String nilai = formatter.format(number);
//        nilai= deleteComa(nilai);
        return nilai;
    }

    public static String toPercent(BigDecimal number) {

        NumberFormat formatter = new DecimalFormat("##.##");
        String nilai = formatter.format(number);
//        nilai= deleteComa(nilai);
        nilai = nilai.replace(".", ",");
        return nilai + "%";
    }

    public static String toCurr(BigDecimal number) {

        NumberFormat formatter = new DecimalFormat("#,###.##");
        String nilai = formatter.format(number);
        nilai = deleteComa(nilai);
        return nilai;
    }

    public static String toCurrMutasi(BigDecimal number) {

        NumberFormat formatter = new DecimalFormat("#,###.##");
        String nilai = formatter.format(number);
        nilai = deleteComa(nilai);
        return nilai;
    }

    public static String toCurrMutasi2(BigDecimal number) {

        NumberFormat formatter = new DecimalFormat("#,###.##");
        String nilai = formatter.format(number);
        nilai = deleteComa(nilai);
        return nilai;
    }

    public static String numberFormat(BigDecimal number) {
        NumberFormat formatter = new DecimalFormat("#,###.##");
        String nilai = formatter.format(number);
        nilai = deleteComa(nilai);
        return nilai;
    }

    public static int dpToInteger(int padding_in_dp, final float scale) {
        int padding_in_px = (int) (padding_in_dp * scale + 0.5f);

        return padding_in_px;
    }

    public static String toCurrDigitGrouping(String number) {
        String nilai = null;
        if (number.equals("0")) {
            nilai = "0";
        } else {
            BigDecimal dec = new BigDecimal(number);
            NumberFormat formatter = new DecimalFormat("#,###.##");
            nilai = formatter.format(dec);
            nilai = nilai.replace(",", ".");

        }
        return "Rp " + nilai;
    }

    public static String toDecimalPercent(Double number) {
        String nilai = null;
        if (number.isNaN()) {
            nilai = "0";
        } else {
            NumberFormat formatter = new DecimalFormat("##.##");
            nilai = formatter.format(number);
            nilai = nilai.replace(".", ",");

        }
        return nilai + "%";
    }

    public static String toCurrDigitGrouping2(String number) {
        BigDecimal dec = new BigDecimal(number);
        NumberFormat formatter = new DecimalFormat("#,###.##");
        return formatter.format(dec);
    }

    public static String toCurrDigitGroupingPln(String number) {
        BigDecimal dec = new BigDecimal(number);
        DecimalFormatSymbols otherSymbol = new DecimalFormatSymbols();
        otherSymbol.setDecimalSeparator(',');
        otherSymbol.setGroupingSeparator('.');
        NumberFormat formatter = new DecimalFormat("#,###.##", otherSymbol);
        String nilai = formatter.format(dec);
//        nilai = nilai.replace(",", ".");
        if ("0".equals(nilai)) return "Rp " + nilai + ",00";
        return "Rp " + nilai;
    }

    public static String toCurrDigitGroupingPln4(String number) {
        BigDecimal dec = new BigDecimal(number);
        DecimalFormatSymbols otherSymbol = new DecimalFormatSymbols();
        otherSymbol.setDecimalSeparator('.');
        otherSymbol.setGroupingSeparator('.');
        NumberFormat formatter = new DecimalFormat("#,###.##", otherSymbol);
        String nilai = formatter.format(dec);
//        nilai = nilai.replace(",", ".");
        if ("0".equals(nilai)) return "Rp. " + nilai + ".00";
        return "Rp. " + nilai;
    }

    public static String toCurrDigitGroupingPln3(String number) {
        BigDecimal dec = new BigDecimal(number);
        DecimalFormatSymbols otherSymbol = new DecimalFormatSymbols();
        otherSymbol.setDecimalSeparator(',');
        otherSymbol.setGroupingSeparator('.');
        NumberFormat formatter = new DecimalFormat("#,###.##", otherSymbol);
        String nilai = formatter.format(dec);
//        nilai = nilai.replace(",", ".");
        if ("0".equals(nilai)) return "Rp. " + nilai + ",00";
        return "Rp. " + nilai;
    }

    public static String toCurrDigitGroupingPln2(String number) {
        BigDecimal dec = new BigDecimal(number);
        DecimalFormatSymbols otherSymbol = new DecimalFormatSymbols();
        otherSymbol.setDecimalSeparator(',');
        otherSymbol.setGroupingSeparator('.');
        NumberFormat formatter = new DecimalFormat("#,###.##", otherSymbol);
        String nilai = formatter.format(dec);
//        nilai = nilai.replace(",", ".");
        if ("0".equals(nilai)) return "Rp " + nilai + ",00";
        if (!nilai.substring(nilai.length() - 3, nilai.length()).startsWith(",")) {
            if (nilai.substring(nilai.length() - 2, nilai.length()).startsWith(",")) {
                nilai += "0";
            } else nilai += ",00";
        }
        return "Rp " + nilai;
    }

    public static String toCurrDigitGroupingPln5(String number) {
        BigDecimal dec = new BigDecimal(number);
        DecimalFormatSymbols otherSymbol = new DecimalFormatSymbols();
        otherSymbol.setDecimalSeparator('.');
        otherSymbol.setGroupingSeparator(',');
        NumberFormat formatter = new DecimalFormat("#,###.##", otherSymbol);
        String nilai = formatter.format(dec);
//        nilai = nilai.replace(",", ".");
        if ("0".equals(nilai)) return "Rp. " + nilai + ".00";
        if (!nilai.substring(nilai.length() - 3, nilai.length()).startsWith(",")) {
            if (nilai.substring(nilai.length() - 2, nilai.length()).startsWith(",")) {
                nilai += "0";
            } else nilai += ".00";
        }
        return "Rp. " + nilai;
    }


/*
    public static String toCurrDigitGrouping2(String number){
		*//*BigDecimal dec = new BigDecimal(number);
		NumberFormat formatter = new DecimalFormat("#,###.##");
		return formatter.format(dec);*//*
         String nilai= deleteComa(moneyFormat(number.toString()));
        return  nilai;
	}*/

    public static String deleteComa(String nilai) {

        int panjang = nilai.length();
        if (mid(nilai, panjang - 2, 2).equals(",0") || mid(nilai, panjang - 2, 2).equals(".0")) {
            nilai = nilai.substring(0, panjang - 2);
        } else if (mid(nilai, panjang - 3, 3).equals(",00") || mid(nilai, panjang - 3, 3).equals(".00")) {
            nilai = nilai.substring(0, panjang - 3);
        } else {
            nilai = nilai;
        }


        nilai = nilai.replace(",", ".");
        return nilai;

    }

    public static String mid(String str, int pos, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0 || pos > str.length()) {
            return "";
        }
        if (pos < 0) {
            pos = 0;
        }
        if (str.length() <= (pos + len)) {
            return str.substring(pos);
        }
        return str.substring(pos, pos + len);
    }


    public static String moneyFormat(String str) {
        String convertedString = str;

        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.')
                break;
            length++;
        }

        if (length > 0) {
            String temp = "";
            int i = length;
            while (i > 0) {
                if (i > 2) {
                    if (temp.equalsIgnoreCase(""))
                        temp = str.substring(i - 3, i);
                    else
                        temp = str.substring(i - 3, i) + "." + temp;
                } else {
                    if (temp.equalsIgnoreCase(""))
                        temp = str.substring(0, i);
                    else
                        temp = str.substring(0, i) + "." + temp;
                    i = 0;
                }
                i = i - 3;
            }
            String decimal = (str.length() == length ? "00" : str
                    .substring(length + 1));
            decimal = (decimal.length() == 1 ? decimal + "0" : decimal);
            convertedString = temp + "," + decimal;
        }

        return convertedString;
    }

    public static String rateFormat(String str) {
        String convertedString = str;

        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.')
                break;
            length++;
        }

        if (length > 0) {
            String temp = "";
            int i = length;
            while (i > 0) {
                if (i > 2) {
                    if (temp.equalsIgnoreCase(""))
                        temp = str.substring(i - 3, i);
                    else
                        temp = str.substring(i - 3, i) + "," + temp;
                } else {
                    if (temp.equalsIgnoreCase(""))
                        temp = str.substring(0, i);
                    else
                        temp = str.substring(0, i) + "," + temp;
                    i = 0;
                }
                i = i - 3;
            }
            String decimal = (str.length() == length ? "00" : str
                    .substring(length + 1));
            decimal = (decimal.length() == 1 ? decimal + "0" : decimal);
            decimal = (decimal.length() == 3 ? decimal.substring(0, 2) : decimal);
            convertedString = temp + "," + decimal;
        }

        return convertedString;
    }
}


