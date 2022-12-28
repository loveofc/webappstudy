import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		Scanner sc = new Scanner(System.in);
		int no = 1;
		Map<String,String> lists = new HashMap<>();
				
		while(true) {
			System.out.println("명령어 입력 : ");
			String cmd=sc.nextLine();

			if(cmd.length()==0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}
			
			if(cmd.equals("article write")) {
				System.out.println("title 입력 : \r");
				String title = sc.nextLine();
				System.out.println("content 입력 : \r");
				String content = sc.nextLine();
				String totalString = title + "\n" + content;
				lists.put(no+"", totalString);
				System.out.println(no+"번 글이 생성되었습니다.");
				no++;
			}else if(cmd.equals("show lists")) {
				for(String key : lists.keySet()) {
					System.out.println(lists.get(key));
				}
			}else if(cmd.equals("exit")) {
				break;
			}else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
		}
		System.out.println("==프로그램 끝==");		
		sc.close();
	}

}
