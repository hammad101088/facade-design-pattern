# facade design pattern with API automation

* implement facade desing pattern as a proof of concept. 
* the project has two test scenarios:
    * checkout scenaio using "object model" design pattern only.
    * checkout scenaio using "object model & facade" design patterns.

### checkout scenario (e-commerce website)
* the checkout scenario consists of the following business actions, and each business action consists of multiple API requests
   * 1- add product to cart (3 API requests)
      * "create cart" request (to get cart id)
      * "get products" request (to get a product id)
      * "add product to cart" request
   * 2- add shipping details (4 API requests)
      * "get regions" request (to get a region id)
      * "get cities" request (to get a city id)
      * "create new address" request (and get the address id)
      * "set billing address on cart" request
   * 3- add payment detials
      * "set shipping method" request
      * "set payment methos" request
   * 4- place order
      * "place order" request
   
* [please refer to this diagram](https://lucid.app/publicSegments/view/c13ff47f-35d7-4e16-900b-bd7c43ff3943/image.png)

