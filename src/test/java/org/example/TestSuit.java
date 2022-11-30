package org.example;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestSuit extends BaseTest {

    HomePage homePage = new HomePage();

    //Registration page
    RegisterPage registerPage = new RegisterPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();

    //Email a friend
    AppleMacBook appleMacBook = new AppleMacBook();
    ProductEmailAFriend productEmailAFriend = new ProductEmailAFriend();

    //Comment on news release
    NewReleaseComment newReleaseComment = new NewReleaseComment();

    Computers computers = new Computers();

    Desktop desktop = new Desktop();

    ElectronicsPage electronicsPage = new ElectronicsPage();

    CameraAndPhoto cameraAndPhoto = new CameraAndPhoto();

    @Test
    public void verifyUserShouldAbleToRegisterSuccessfully()
    {
        homePage.verifyRegisterButtonPresent();
        //clickonregisterbutton
        homePage.clickOnRegisterButton();

        //enter your register details
        registerPage.verifyUserOnRegisterPage();

        //verify user suceessfully


        registrationResultPage.verifyUserRegisterSuccessfully();
    }

    @Test
    public void verifyEachProductHasName(){
        //Navigate to electronics
        homePage.navigateToElectronicsPage();

        //Navigate to camera & photo
        electronicsPage.navigateToCameraAndPhoto();

        //Verify each product has name
        cameraAndPhoto.getProductsName();

    }


    @Test
    public void VerifyIfUserCaneMailAFriend(){

        //Click on MacBook Pro product
        homePage.clickOnMacBookPro();
        //Click on email a friend button
        appleMacBook.clickOnEMailAFriend();
        //Fill details of email a friend
        productEmailAFriend.friendEmailDetails();
    }

    @Test
    public void verifyToPrintCategoriesList(){
        homePage.printProductCategoriesList();
    }

//    @Test
//    public void commentOnNewsRelease(){
//        homePage.clickOnNewsDetailsButton();
//        newReleaseComment.commentOnNewRelease();
//    }
    @Test
    public void product()
    {
        homePage.clickOnComputer();
        computers.clickOnDesktop();
        desktop.productLists();
    }

    @Test
    public void verifyCorrectCurrencySymbolDisplayedOnEachProduct(){
        homePage.checkDollarSymbol();

        homePage.selectEuroSymbol();

        homePage.verifyEuroSymbolOnHomePage();

    }

    @Test
    public void verifyPopUpAlertShouldBeAccepted(){
        homePage.voteButton();
        homePage.handleVoteAlert();
    }

    @Test
    public void verifyCommentShouldBeAtTheBottom(){
        homePage.clickOnNewsDetailsButton();
        newReleaseComment.commentOnNewRelease();
        newReleaseComment.verifyCommentAddedMessage();
        newReleaseComment.verifyCommentAddedAtLast();

    }

    @Test
    public void verifyUserShouldBeAbleToComeBackToMainTab(){
        homePage.ClickOnFacebookSymbolAndThenComeBackToMainTab();
    }

    @Test
    public void verifyUserShouldBeAbleToNavigateToDesktopByMouseHovering(){
        homePage.navigateToDesktopByMouseHovering();
    }

    @Test
    public void verifyIfTheColorChangesWhenHoveringTheMouse(){
        homePage.noticeChangeOfTheColor();
    }

    @Test
    public void VerifyIfTheSearchBoxWorksProperly(){
        homePage.searchBoxWorkingProperly();
    }
}
