package model.publisher;

import java.util.ArrayList;

public interface IPublisherDAO {
	public boolean insert(PublisherDTO dto) throws Exception;

	public boolean update(PublisherDTO dto) throws Exception;

	public boolean delete(PublisherDTO dto) throws Exception;

	public ArrayList<PublisherDTO> getAllPublisher() throws Exception;
}
