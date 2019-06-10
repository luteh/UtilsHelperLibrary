/**
 * 
 */
package com.kazee.utilshelper.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

/**
 * @author abiandono
 *
 */
public class ResourceUtil {
	private static ResourceBundle RESOURCE_BUNDLE = null ;
	
	private ResourceUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static final ResourceBundle getBundle(){
	    //= ResourceBundle.getBundle( BUNDLE_NAME );
	    //Hack for android problem with resource bundles.
	    if(RESOURCE_BUNDLE == null){
			ResourceBundle bundle = new ListResourceBundle(){
				protected Object[][] getContents() {
					String[][] arr  = new String[][] {
							{"IB-0000","Problem komunikasi dengan server"},
							{"IB-0001","Activation failed null response received from server"},
							{"IB-0002","Tidak ada data"},
							{"IB-0003","Tidak bisa mendapatkan posisi, cek gps atau network provider anda"},
							{"IB-0600","Problem komunikasi dengan server"},
							{"IB-0999","Invalid Mobile User ID"},
							{"IB-1000","Data otentikasi tidak valid. Silahkan masukkan data otentikasi dengan benar."},
							{"IB-1001","Data sesi aplikasi tidak valid. Silahkan login kembali."},
							{"IB-1002","User belum teregistrasi"},
							{"IB-1003","Perangkat belum teregistrasi atau belum aktif"},
							{"IB-1004","Data nasabah tidak ditemukan"},
							{"IB-1005","Data nasabah tidak ditemukan"},
							{"IB-1006","Data perangkat tidak ditemukan"},
							{"IB-1007","Data otentikasi tidal valid. Kode error: {0}"},
							{"IB-1008","Kode aktivasi tidak valid"},
							{"IB-1009","Problem komunikasi dengan server. Kode error:{0}"},
							{"IB-1010","Sesi aplikasi telah habis. Silahkan login kembali."},
							{"IB-1011","Tipe rekening tidak valid"},
							{"IB-1012","Data network/delivery channel belum diisi Silahkan masukkan data network/delivery channel yang diinginkan."},
							{"IB-1013","Nilai transfer tidak valid atau di luar limit yang telah ditentukan."},
							{"IB-1014","Nomer telepon tidak valid untuk operator yang dipilih."}
						};
					return arr;
				}
		    };
		    
		    RESOURCE_BUNDLE = bundle;
		}
	    
		return RESOURCE_BUNDLE;
	}

	public static String encodeImage(Bitmap bm)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
		byte[] b = baos.toByteArray();
		String encImage = Base64.encodeToString(b, Base64.DEFAULT);

		return encImage;
	}

	public static String encodeImagePath(String path)
	{
		Uri imageUri2 = Uri.parse(path);
		File imagefile = new File(imageUri2.getPath());
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(imagefile);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		Bitmap bm = BitmapFactory.decodeStream(fis);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.JPEG,20,baos);
		byte[] b = baos.toByteArray();
		String encImage = Base64.encodeToString(b, Base64.NO_WRAP);
		//Base64.de
		return encImage;

	}
}
