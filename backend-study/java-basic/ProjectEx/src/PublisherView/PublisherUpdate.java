package PublisherView;

import java.util.Scanner;

import controller.publisherController;
import model.publisher.PublisherDTO;

public class PublisherUpdate {
	publisherController controller = publisherController.getInstance();

	public void update(Scanner sc) {
		String pubNo, pubName;

		System.out.println("\n*************************");
		System.out.println("출판사 정보 수정");
		System.out.println("***************************");

		PublisherList list = new PublisherList();
		list.getAllPublisher();

		System.out.print("수정할 출판사번호 입력 : ");
		pubNo = sc.nextLine();

		System.out.print("출판사명 입력 : ");
		pubName = sc.nextLine();
		System.out.println("***************************");

		controller.update(new PublisherDTO(pubNo, pubName));
	}
}
