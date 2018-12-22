import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* Class MyBigNumber là lớp để Cộng 2 số với input là 2 chuỗi số.
* Hàm sum trong Class MyBigNumber là hàm để thực hiện phép cộng 2 chuỗi số.
*/

public class MyBigNumber { 
    
    private IReceiver ireceiver;

    /**
    * DesCription. 
    * @param ireceiver
    * 
    */
    
    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }
    
    /**
    * Phương thức cộng 2 chuỗi số làm tham số cho hàm sum:
    * 2 chuỗi này đều chỉ chứa các kí tự số từ '0' đến '9'.
    * @param s1 chuỗi số thứ nhất.
    * @param s2 chuỗi số thứ hai.
    * @return chuỗi có giá trị là tổng của hai số s1 và s2.
    */
  
    public String sum(final String s1, final String s2) { 
        int str1 = s1.length(); // độ dài của 2 chuỗi 
        int str2 = s2.length(); 
        final int max = (str1 > str2) ? str1 : str2; // lấy độ dài lớn nhất giữa str1 va str2 
        String result = "";// biến kết quả phép tính
        int sur = 0;// biến lưu giá trị dư 
        int pos1;// vị trí cuối cùng của chuỗi số 1 và 2 
        int pos2; 
        char digit1 = '0'; // biến lưu ký tự được lấy ra 
        char digit2 = '0'; 
        int tong = 0;// biến để cộng 2 kí tự cuối cùng lại với nhau 
        int a; // số được lấy ra từ vị trí pos của chuỗi s1 và s2
        int b; 
        int temp; // biến nhớ tạm
        int temp2; 
        String msg = ""; // Thông điệp in ra từng bước cộng
        int errorPos; // Vị trí lỗi
        int s; // biến đếm bước thực hiện
        
        Pattern pattern = Pattern.compile("\\D");// Chuỗi đại diện cho kí tự số từ 0 đến 9
        Matcher matcher1 = pattern.matcher(s1);
        Matcher matcher2 = pattern.matcher(s2);
        
        // Kiếm tra hai chuỗi đã đúng dạng hay chưa 
        if (matcher1.find()) {
            msg = "Vui lòng không nhập chữ, ký tự đặt biệt hoặc khoảng trắng."
                    + "\nVị trí " + (matcher1.start() + 1) + " trong chuỗi 1: " + s1 + "\nkhông phải là số";
            this.ireceiver.send(msg);
            errorPos = matcher1.start() + 1;
            throw new NumberFormatException(errorPos + "");
            
        }

        if (matcher2.find()) {
            msg = "Vui lòng không nhập chữ, ký tự đặt biệt hoặc khoảng trắng."
                    + "\nVị trí " + (matcher2.start() + 1) + " trong chuỗi 2: " + s2 + "\nkhông phải là số";
            this.ireceiver.send(msg);
            errorPos = matcher2.start() + 1;
            throw new NumberFormatException(errorPos + "");
        }
        
        // Neu ca hai dong rong thi ket qua bang 0
        if (s1.isEmpty() && s2.isEmpty()) {
            result = "0";
            
            return result; 
        }

        int i = 0; // biến lặp
        // tính toán
        for (i = 0; i < max; i++) { 
            pos1 = str1 - i - 1;// cập nhật vị trí của ký tự 
            pos2 = str2 - i - 1; 
            
            if (pos1 >= 0) { 
                digit1 = s1.charAt(pos1); // lấy ký tự cuối cùng của chuỗi 
                a = digit1 - '0';
            } else {
                a = 0;
            }
            
            if (pos2 >= 0) { 
                digit2 = s2.charAt(pos2); 
                b = digit2 - '0';
            } else {
                b = 0;
            }

            tong = a + b + sur;// chuyển ký tự thành số rồi cộng cho số dư 
            temp = sur;
            temp2 = tong;
            if (tong > 9) { // cập nhật lại số dư 
                sur = 1;
                temp = sur;
                tong %= 10;
            } else {
                sur  = 0;
            }
    
            s = i + 1;
            if (max == 1 && s == max && temp2 == 10) {
                msg += "Bước " + s + ": " + a + " + " + b + " = "
                    + (a + b) + ". \nViết " + temp2 + "\n";
            } else {
                if (s == 1) {
                    msg += "Bước " + s + ": " + a + " + " + b + " = "
                        + (a + b) + ". \nViết " + tong + " nhớ " + sur + "\n";
                } else if (s == max) {
                    msg += "Bước " + s + ": " + a + " + " + b + " = "
                        + (a + b) + " + " + temp +  " = " + temp2 + " . \nViết " + temp2 + "\n";
                } else {
                    msg += "Bước " + s + ": " + a + " + " + b + " = "
                        + (a + b) + "+" + temp +  " = " + temp2 + ". \nViết " + tong + " nhớ " + sur + "\n";
                } 
            }
        
            result = tong + result; // Lấy kết quả biến 'tong' chia lấy dư cho 10 sau đó cộng dồn vào 'result'
        }
        
        if (sur == 1) {
            result = 1 + result; // Sau khi vòng lặp kết thúc nếu còn số dư, cộng vào ký tự đầu tiên của chuỗi kết quả
        }
        
        this.ireceiver.send(msg);
        
        return result;
        
    }
}