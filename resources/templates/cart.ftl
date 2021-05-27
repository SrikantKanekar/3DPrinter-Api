<#import "base.ftl" as layout />
<#import "header.ftl" as header />
<@layout.base title="Cart" css="/static/css/cart.css" js="/static/js/cart.js">

    <@header.header user="${user}" title="Cart" />
    
    <div class="container">
        
        <#if objects?has_content>

            <div class="row">
                <div class="col">
                    <div class="cart_info_columns clearfix">
                        <div class="cart_info_col cart_info_col_object">
                            Object
                        </div>
                        <div class="cart_info_col cart_info_col_price">
                            Price
                        </div>
                        <div class="cart_info_col cart_info_col_quantity">
                            Quantity
                        </div>
                    </div>
                </div>
            </div>

            <#list objects as object>
                <div class="row">
                    <div class="col">
                        <div class="cart_item">
                            
                            <!-- Name -->
                            <div class="cart_item_object">
                                
                                <div class="cart_item_image">
                                    <div><img src="${object.image}" alt=""/></div>
                                </div>
                                
                                <div class="cart_item_name_container">
                                    <div class="cart_item_name">
                                        <a href="/object/${object.id}">${object.filename}</a>
                                    </div>
                                    <div class="cart_item_edit">
                                        <a href="/cart/${object.id}/remove">remove</a>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Price -->
                            <div class="cart_item_price">&#8377;${object.price}</div>
                            
                            <!-- Quantity -->
                            <div class="cart_item_quantity">
                                <div class="product_quantity_container">
                                    <div class="product_quantity clearfix">
                                        <span>Qty</span>
                                        <input id="quantity_input" type="text" pattern="[0-9]*" value="1" />
                                        <div class="quantity_buttons">
                                            <div id="quantity_inc_button" class="
                                                        quantity_inc
                                                        quantity_control
                                                    ">
                                                <i class="fa fa-chevron-up" aria-hidden="true"></i>
                                            </div>
                                            <div id="quantity_dec_button" class="
                                                        quantity_dec
                                                        quantity_control
                                                    ">
                                                <i class="
                                                            fa fa-chevron-down
                                                        " aria-hidden="true"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>

            <div class="row row_cart_buttons">
                <div class="col">
                    <div class="
                                cart_buttons
                                d-flex
                                flex-lg-row flex-column
                                align-items-start
                                justify-content-start
                            ">
                        <div class="button continue_shopping_button">
                            <a href="#">Continue shopping</a>
                        </div>
                        <div class="cart_buttons_right ml-lg-auto">
                            <div class="button clear_cart_button">
                                <a href="#">Clear cart</a>
                            </div>
                            <div class="button update_cart_button">
                                <a href="#">Update cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row row_extra">
                
                <!-- Coupon Code -->
                <div class="col-lg-4">
                    <div class="coupon">
                        <div class="section_title">Coupon code</div>
                        <div class="section_subtitle">
                            Enter your coupon code
                        </div>
                        <div class="coupon_form_container">
                            <form action="#" id="coupon_form" class="coupon_form">
                                <input type="text" class="coupon_input" required="required" />
                                <button class="button coupon_button">
                                    <span>Apply</span>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>

                <!-- Cart Total -->
                <div class="col-lg-6 offset-lg-2">
                    <div class="cart_total">
                        <div class="section_title">Cart total</div>
                        <div class="section_subtitle">Final info</div>
                        <div class="cart_total_container">
                            <ul>
                                <li class="
                                            d-flex
                                            flex-row
                                            align-items-center
                                            justify-content-start
                                        ">
                                    <div class="cart_total_title">
                                        Subtotal
                                    </div>
                                    <div class="cart_total_value ml-auto">
                                        $790.90
                                    </div>
                                </li>
                                <li class="
                                            d-flex
                                            flex-row
                                            align-items-center
                                            justify-content-start
                                        ">
                                    <div class="cart_total_title">
                                        Shipping
                                    </div>
                                    <div class="cart_total_value ml-auto">
                                        Free
                                    </div>
                                </li>
                                <li class="
                                            d-flex
                                            flex-row
                                            align-items-center
                                            justify-content-start
                                        ">
                                    <div class="cart_total_title">
                                        Total
                                    </div>
                                    <div class="cart_total_value ml-auto">
                                        $790.90
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="button checkout_button">
                            <a href="/checkout">Proceed to checkout</a>
                        </div>
                    </div>
                </div>
            </div>
        <#else>
            <div class="no_items_text">No items</div>
        </#if> 
    </div>     
</@layout.base>