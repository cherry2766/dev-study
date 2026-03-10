package model.client;

import java.util.ArrayList;

public interface IClientDAO {
	public ArrayList<ClientDTO> getAllClient() throws Exception;

	public boolean insert(ClientDTO dto) throws Exception;

	public boolean update(ClientDTO dto) throws Exception;

	public boolean delete(ClientDTO dto) throws Exception;

	public boolean login(ClientDTO dto) throws Exception;
}
