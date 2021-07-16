package com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.mapper;

import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import com.telefonica.gal.provisionApi.model.Subscription;
import com.telefonica.gal.provisionApi.model.User;
import com.telefonica.gal.provisionApi.model.UserProducts;
import com.telefonica.gal.provisionApi.model.ProductOperation;
import com.telefonica.gal.provisionApi.model.ProductsMode;
import com.telefonica.gal.provisionApi.model.SubscribedProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CDBProvisionRequestMapper {

    @Mapping(source = "adminCode", target = "uniqueId")
    @Mapping(constant = "OTT", target = "serviceType")
    @Mapping(source = "request.clientSegmentName", target = "commercialOffer")
    @Mapping(target = "limitVodPurchases", expression = "java(getLimitVodPurchases(request))")
    @Mapping(target = "products.productsMode", expression = "java(getProductsMode())")
    @Mapping(target = "products", expression = "java(getUserProducts(request))")
    User userDataMapper(CDBProvisionRequest request, String adminCode);

    default Integer getLimitVodPurchases(CDBProvisionRequest request) {
        if (request.getServiceFlags().getTransactionalPurchases().equals(1)) {
            return -1;
        } else {
            return 0;
        }
    }

    default UserProducts getUserProducts(CDBProvisionRequest request) {
        UserProducts userProducts = new UserProducts();

        List<Subscription> subscriptionsList = new ArrayList<>();
        Subscription subscription = new Subscription();

        for (SubscribedProduct subscribedProduct : request.getSubscribedProducts()) {
            subscription.setOperation(ProductOperation.ON);
            subscription.setProductId(subscribedProduct.getCode());
            subscription.setPendingConsolidation(0);
            subscriptionsList.add(subscription);
        }

        userProducts.setSubscriptionsList(subscriptionsList);

        return userProducts;
    }

    default ProductsMode getProductsMode() {
        return ProductsMode.SNAPSHOT;
    }
}
