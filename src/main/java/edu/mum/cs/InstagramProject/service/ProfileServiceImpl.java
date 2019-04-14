package edu.mum.cs.InstagramProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.InstagramProject.domain.Profile;
import edu.mum.cs.InstagramProject.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	ProfileRepository profileRepository;

	public ProfileServiceImpl() {

	}

	@Override
	public Profile getProfile(String profileId) {
		Profile profile = profileRepository.findById(profileId).orElse(null);
		return profile;
	}

	@Override
	public Profile saveProfile(Profile profile) {
		profileRepository.save(profile);
		return profile;
	}

	@Override
	public Profile updateProfile(Profile profile) {
		Profile oldProfile = getProfile(profile.getUserName());
		if (!oldProfile.equals(null)) {
			profileRepository.delete(oldProfile);
			profileRepository.save(profile);
			return profile;
		} else {
			return null;
		}

	}

	@Override
	public Profile deleteProfile(String profileId) {
		Profile oldProfile = getProfile(profileId);
		if (oldProfile != null) {
			profileRepository.delete(oldProfile);
			return oldProfile;
		}
		return null;
	}

	@Override
	public List<Profile> getProfileList() {

		return profileRepository.findAll();
	}

}
