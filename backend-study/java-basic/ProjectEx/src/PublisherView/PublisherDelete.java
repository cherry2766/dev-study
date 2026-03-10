package PublisherView;

import java.util.Scanner;

import controller.publisherController;

public class PublisherDelete {
	publisherController controller = publisherController.getInstance();

	public void delete(Scanner sc) {
		String pubNo;

		System.out.println("\n*************************");
		System.out.println("출판사 정보 삭제");
		System.out.println("***************************");

		PublisherList list = new PublisherList();
		list.getAllPublisher();

		System.out.print("삭제할 출판사번호 입력 : ");
		pubNo = sc.nextLine();
		System.out.println("***************************");

		controller.delete(pubNo);
	}
}
