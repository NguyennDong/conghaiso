/**
* Class MyBigNumber là lớp để Cộng 2 số với input là 2 chuỗi số.
* Hàm sum trong Class MyBigNumber là hàm để thực hiện phép cộng 2 chuỗi số.
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyBigNumber { 

    /**
    * Phương thức cộng 2 chuỗi số làm tham số cho hàm sum:
    * 2 chuỗi này đều chỉ chứa các kí tự số từ '0' đến '9'.
    * @param s1 chuỗi số thứ nhất.
    * @param s2 chuỗi số thứ hai.
    * @return chuỗi có giá trị là tổng của hai số s1 và s2.
    */
  
    public String[] sum(final String s1, final String s2) { 
        String result = "";// biến kết quả phép tính
        int str1 = s1.length(); // độ dài của 2 chuỗi 
        int str2 = s2.length(); 
        String[] ketqua = new String[2];
        int max = (str1 > str2) ? str1 : str2;// lấy độ dài lớn nhất giữa str1 va str2 
        int sur = 0;// biến lưu giá trị dư 
        int pos1;// vị trí cuối cùng của chuỗi số 1 và 2 
        int pos2; 
        char digit1 = '0'; // biến lưu ký tự được lấy ra 
        char digit2 = '0'; 
        int tong = 0;// biến để cộng 2 kí tự cuối cùng lại với nhau 
        int a, b; // số được lấy ra từ vị trí pos của chuỗi s1 và s2
        int temp; // biến nhớ tạm
        int temp2; 
        String msg = ""; // Thông điệp in ra từng bước cộng.
        int i; // biến lặp
        
        // Kiếm tra hai chuỗi đã đúng dạng hay chưa 
        ketqua[0] = "";
        for (i = 0; i < str1; i++){
            if (Character.isLetter(s1.charAt(i))){
                ketqua[1] = "Vị trí " + (i + 1) + " trong chuỗi 1 " + s1 + "\nkhông phải là số";
		return ketqua;
            }
	}

	for (i = 0; i < str2; i++){
            if (Character.isLetter(s2.charAt(i))) {
                ketqua[1] = "Vị trí " + (i + 1) + " trong chuỗi 2 " + s2 + "\nkhông phải là số";
		return ketqua;
            }
	}
			
	Pattern pattern1 = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]");
	Matcher matcher1 = pattern1.matcher(s1);
	Pattern pattern2 = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]");
	Matcher matcher2 = pattern2.matcher(s2);
			
	if (matcher1.find()) {
            ketqua[1] = "Vị trí " + (matcher1.start() + 1) + " trong chuỗi 1 " + s1 + "\nkhông phải là số";
            return ketqua;
	}

	if (matcher2.find()) {
            ketqua[1] = "Vị trí " + (matcher2.start() + 1) + " trong chuỗi 1 " + s1 + "\nkhông phải là số";
            return ketqua;
	}
        
        // tính toán
        for (i = 0; i < max; i++) { 
            pos1 = str1 - i - 1;// cập nhật vị trí của ký tự 
            pos2 = str2 - i - 1; 
            
            if (pos1 >= 0) { 
                digit1 = s1.charAt(pos1); // lấy ký tự cuối cùng của chuỗi 
                a = digit1 - '0';
            } 
            else{
                a = 0;
            }
            if (pos2 >= 0) { 
                digit2 = s2.charAt(pos2); 
                b = digit2 - '0';
            } 
            else{
                b = 0;
            }

            tong = a + b + sur;// chuyển ký tự thành số rồi cộng cho số dư 
            temp = sur;
            temp2 = tong;
            if(tong > 9){// cập nhật lại số dư 
                sur = 1;
                temp = sur;
                tong %= 10;
            }
            else{
                sur  = 0;
            }
            
            int B = i + 1;
            if (B == 1){
                msg += "Bước " + B + ": " + a + " + " + b + " = "
                    + (a + b) + ". \nViết " + tong + " nhớ " + sur + "\n";
            }
            else if (B == max){
                msg += "Bước " + B + ": " + a + " + " + b + " = "
                    + (a + b) + "+" + temp +  " = " + temp2 + " . \nViết " + temp2 + "\n";
            }
            else{
                msg += "Bước " + B + ": " + a + " + " + b + " = "
                    + (a + b) + "+" + temp +  " = " + temp2 + " . \nViết " + tong + " nhớ " + sur + "\n";
            }
            result = tong + result; // Lấy kết quả biến 'tong' chia lấy dư cho 10 sau đó cộng dồn vào 'result'
        }
        if (sur == 1){
            result = 1 + result; // Sau khi vòng lặp kết thúc nếu còn số dư, lấy số dư cộng vào ký tự đầu tiên của chuỗi kết quả
        }
        ketqua[0] = result;
        ketqua[1] = msg;
        return ketqua;
    }
}