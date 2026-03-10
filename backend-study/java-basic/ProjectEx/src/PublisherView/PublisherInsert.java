package PublisherView;

import java.util.Scanner;

import controller.publisherController;
import model.publisher.PublisherDTO;

public class PublisherInsert {
	publisherController controller = publisherController.getInstance();

	public void insert(Scanner sc) {
		String pubNo, pubName;

		System.out.println("\n*************************");
		System.out.println("출판사 정보 등록");
		System.out.println("***************************");

		System.out.print("출판사번호 입력 : ");
		pubNo = sc.nextLine();

		System.out.print("출판사명 입력 : ");
		pubName = sc.nextLine();
		System.out.println("***************************");

		controller.insert(new PublisherDTO(pubNo, pubName));
	}

}
