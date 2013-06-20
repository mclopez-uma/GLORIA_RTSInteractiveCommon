package eu.gloria.rtc;

import java.util.List;

import eu.gloria.rt.entity.device.DbFileInfo;
import eu.gloria.rt.entity.device.DbFileMetadata;
import eu.gloria.rt.entity.device.DbFileSystemInfo;
import eu.gloria.rt.entity.device.Device;
import eu.gloria.rt.entity.device.DeviceCamera;
import eu.gloria.rt.entity.device.DeviceType;
import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.DBInterface;
import eu.gloria.rtc.DeviceDiscoverer;
import eu.gloria.rtd.RTDDBInterface;


public class DBControl extends DeviceManager implements DBInterface {

	
	/**
	 * Constructor
	 */
	public DBControl () {
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean dbIsAvailableDirectAccess(String deviceId)
			throws RTException {
		
		return  ((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbIsAvailableDirectAccess();
	}

	@Override
	public boolean dbIsAvailableChunkAccess(String deviceId) throws RTException {
		
		return  ((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbIsAvailableChunkAccess();
	}

	@Override
	public boolean dbIsAvailableURIAccess(String deviceId) throws RTException {

		return  ((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbIsAvailableChunkAccess();
	}

	@Override
	public DbFileInfo dbGetFileInfo(String deviceId, String folder, String fileName) throws RTException {

		return  ((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbGetFileInfo(folder, fileName);
	}

	@Override
	public List<Byte> dbGetFileContent(String deviceId, String folder, String fileName) throws RTException {

		return  ((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbGetFileContent(folder, fileName);
	}

	@Override
	public List<Byte> dbGetFileChunk(String deviceId, String fileName, long offset,	long size) throws RTException {

		return  ((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbGetFileChunk(fileName, offset, size);
	}

	@Override
	public String dbGetFileURI(String deviceId, String fileName)	throws RTException {

		return  ((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbGetFileURI(fileName);
	}

	@Override
	public void dbWriteFile(String deviceId, String fileName, List<Byte> content,List<DbFileMetadata> metadata) throws RTException {

		((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbWriteFile(fileName, content, metadata);

	}

	@Override
	public List<DbFileMetadata> dbGetMetadata(String deviceId, String fileName)	throws RTException {

		return ((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbGetMetadata(fileName);

	}

	@Override
	public DbFileSystemInfo dbGetFileSystemInfo(String deviceId)
			throws RTException {

		return ((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbGetFileSystemInfo();
	}

	@Override
	public void dbRenameFile(String deviceId, String currentFileName,
			String newFileName) throws RTException {

		((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbRenameFile(currentFileName, newFileName);
	}

	@Override
	public void dbDeleteFile(String deviceId, String fileName)
			throws RTException {

		((RTDDBInterface) DeviceDiscoverer.getRTD(deviceId)).dbDeleteFile(fileName);

	}

}
