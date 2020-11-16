/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps12656_asm_java3;

/**
 *
 * @author DMX
 */
public class SVDiem {
    String maSv;  
    String hoTen;
    float tiengAnh;
    float tinHoc;
    float GDTC;
    float DiemTb;

    public SVDiem() {
    }

    public SVDiem(String maSv, String hoTen, float tiengAnh, float tinHoc, float GDTC) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(float tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public float getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(float tinHoc) {
        this.tinHoc = tinHoc;
    }

    public float getGDTC() {
        return GDTC;
    }

    public void setGDTC(float GDTC) {
        this.GDTC = GDTC;
    }

    public float getDiemTb() {
        return (tiengAnh+tinHoc+GDTC)/3;
    }

    public void setDiemTb(float DiemTb) {
        this.DiemTb = DiemTb;
    }


    
    
}
