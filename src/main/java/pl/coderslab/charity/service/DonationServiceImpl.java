package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    @Autowired
    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation findById(long id) {
        return donationRepository.findById(id).get();
    }

    @Override
    public void delete(long id) { donationRepository.deleteById(id); }

    @Override
    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public long sumAllGivenBags() {
        return donationRepository.sumAllGivenBags();
    }

    @Override
    public long sumAllDonations() { return donationRepository.countAllDonations(); }
}
