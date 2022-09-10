package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.FileVO;

import lombok.NonNull;

public interface FileDAO {
	public int insertFile(FileVO fvo);
	public List<FileVO> selectListFile(long pno);
	public FileVO selectProfile(String email);
	public int deleteFile(String uuid);
	public int deleteAllFile(long pno);
	public int insertProfile(FileVO fvo);
	public List<FileVO> selectAllFiles();

}
