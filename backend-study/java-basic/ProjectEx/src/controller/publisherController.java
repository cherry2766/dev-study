package controller;

import java.util.ArrayList;

import PublisherView.PublisherList;
import model.publisher.IPublisherDAO;
import model.publisher.PublisherDAO;
import model.publisher.PublisherDTO;
import util.ResultView;

public class publisherController {
	private static publisherController instance = new publisherController();
	IPublisherDAO dao = new PublisherDAO();

	private publisherController() {

	}

	public static publisherController getInstance() {
		return instance;
	}

	public void insert(PublisherDTO newDto) {
		try {
			PublisherDTO dto = new PublisherDTO();

			dto.setPubNo(newDto.getPubNo());
			dto.setPubName(newDto.getPubName());

			if (dao.insert(dto)) {
				ResultView.succMsg("출판사 정보가 등록되었습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("오류가 발생했습니다");
		}
	}

	public void update(PublisherDTO newDto) {

		try {
			PublisherDTO dto = new PublisherDTO();

			dto.setPubNo(newDto.getPubNo());
			dto.setPubName(newDto.getPubName());

			if (dao.update(dto)) {
				ResultView.succMsg("출판사 정보가 수정되었습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("오류가 발생했습니다");
		}
	}

	public void delete(String pubNo) {
		try {
			PublisherDTO dto = new PublisherDTO();

			dto.setPubNo(pubNo);

			if (dao.delete(dto)) {
				ResultView.succMsg("출판사 정보를 삭제하였습니다");
			} else {
				ResultView.succMsg("해당하는 출판사 번호의 출산사가 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("오류가 발생했습니다");
		}
	}

	public void getAllPublisher() {
		try {
			ArrayList<PublisherDTO> publisherList = dao.getAllPublisher();

			if (publisherList.size() != 0) {
				PublisherList.showAllPublisher(publisherList);
			} else {
				ResultView.succMsg("검색 결과가 없습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("잠시 후 재요청 바랍니다");
		}
	}

}
