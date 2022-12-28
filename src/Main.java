import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		Scanner sc = new Scanner(System.in);
		int no = 1;
		List<Article> lists = new ArrayList<>();
				
		while(true) {
			System.out.println("명령어 입력 : ");
			String cmd=sc.nextLine().trim();

			if(cmd.length()==0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}
			
			if(cmd.equals("article write")) {
				System.out.println("title 입력 : ");
				String title = sc.nextLine();
				System.out.println("content 입력 : ");
				String content = sc.nextLine();
				Article article = new Article(no,title,content);
				lists.add(article);				
				System.out.println(no+"번 글이 생성되었습니다.");
				no++;
				
			}else if(cmd.equals("show lists")) {
				if(lists.size()==0) {
					System.out.println("목록이 없습니다.");
					continue;
				}
				System.out.println("제목  |  내용");
				for(int i = lists.size()-1;i>=0; i--) {
					System.out.printf("%s  |  %s\n", lists.get(i).getTitle(),lists.get(i).getContent());
				}
				
			}else if(cmd.startsWith("article detail ")) {
				String [] comBits = cmd.split(" ");
				boolean found = false;
				int id = Integer.parseInt(comBits[2]);
				int index =0;
				index = found(id,lists);
				if(index>=0) {
					found=true;
				}
				if(!found) {
					System.out.println("게시물이 존재하지 않습니다.");
					continue;
				}else {
					System.out.println("제목 || 내용");
					System.out.printf("%s || %s",lists.get(index).getTitle(), lists.get(index).getContent());
				}
				
			}else if(cmd.startsWith("delete ")) {
				
				String [] comBits = cmd.split(" ");
				boolean found = false;
				int id = Integer.parseInt(comBits[1]);
				int index =0;
				index = found(id,lists);
				if(index>=0) {
					found=true;
				}
				if(!found) {
					System.out.println("게시물이 존재하지 않습니다.");
					continue;
				}else {
					lists.remove(index);
					System.out.println("게시물이 삭제 하였습니다.");
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
	
	public static int found(int id,List<Article> lists) {
		int index =0;
		for(Article article : lists) {
			if(article.getId()==id) {
				index = lists.indexOf(article);				
				break;
			}					
		}
		
		return index ;
	}

}

class Article{
	private int id;
	private String title;
	private String content;
	
	public Article(int id, String title, String content) {
		this.id=id;
		this.title=title;
		this.content=content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	
}