package edu.mum.cs.InstagramProject.service;

import java.util.List;


import edu.mum.cs.InstagramProject.domain.Profile;

public interface ProfileService  {
	
	public Profile getProfile(String profileId);

	public Profile saveProfile(Profile profile);

	public Profile updateProfile(Profile profile);

	public Profile deleteProfile(String profileId);

	public List<Profile> getProfileList();

}
