package com.eazybytes.cards.service.Impl;

import com.eazybytes.cards.constants.CardsConstants;
import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.entity.Cards;
import com.eazybytes.cards.exception.CardAlreadyExistsException;
import com.eazybytes.cards.exception.ResourceNotFoundException;
import com.eazybytes.cards.mapper.CardsMapper;
import com.eazybytes.cards.repository.CardsRepository;
import com.eazybytes.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {
    CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> cards = cardsRepository.findByMobileNumber(mobileNumber);
        if (cards.isPresent()) {
            throw new CardAlreadyExistsException("card bond to number " + mobileNumber + " already exists");
        }
        cardsRepository.save(createNewCard(mobileNumber));

    }

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        newCard.setMobileNumber(mobileNumber);
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards optionalCard = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card info", "Mobile Number", mobileNumber)
        );
        return CardsMapper.mapToCardsDto(optionalCard, new CardsDto());
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Cards optionalCard = cardsRepository.findByMobileNumber(cardsDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card info", "Mobile Number", cardsDto.getMobileNumber())
        );
        Cards cards = CardsMapper.mapToCards(cardsDto, optionalCard);
        cardsRepository.save(cards);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {

        Cards optionalCard = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card info", "Mobile Number", mobileNumber)
        );
        cardsRepository.deleteByCardId(optionalCard.getCardId());

        return true;
    }
}
