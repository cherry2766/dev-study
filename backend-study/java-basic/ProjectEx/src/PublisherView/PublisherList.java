package PublisherView;

import java.util.ArrayList;

import controller.publisherController;
import model.publisher.PublisherDTO;

public class PublisherList {
	publisherController controller = publisherController.getInstance();

	public void getAllPublisher() {
		controller.getAllPublisher();
	}

	public static void showAllPublisher(ArrayList<PublisherDTO> publisherList) {
		System.out.println("\n*******************************");
		System.out.println("출판사 정보 조회");
		System.out.println("*********************************");

		System.out.println("출판사번호\t 출판사명");
		System.out.println("----------------------");

		for (PublisherDTO dto : publisherList) {
			System.out.println(dto);
		}
	}
}
