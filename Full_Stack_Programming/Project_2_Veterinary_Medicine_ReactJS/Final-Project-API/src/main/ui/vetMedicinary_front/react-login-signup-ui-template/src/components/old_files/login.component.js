import React, { Component } from "react";

export default class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {
          date: new Date().toLocaleString()
        };
      }

    render() {
        return (
            <div className="login">
                <header>
                    <div className="header-container blog-main-clear">
                        <div className="header-date-container">
                            <div className="header-date-inner">{this.state.date}</div>
                        </div>
                        <div className="header-logo-container">
                            <div className="header-logo-inner"></div>
                        </div>
                    </div>
                </header>
                <div className="body-container">
                    <form>
                        <div className="login-signup-inner">
                            <h3 id="form-title">Sign In</h3>
                            <div className="login-input-container form-group">
                                <label>Name</label>
                                <input type="text" className="form-control" placeholder="Enter Name" />
                            </div>
                            <div className="login-input-container form-group">
                                <label>Password</label>
                                <input type="password" className="form-control" placeholder="Enter password" />
                            </div>
                            <button type="submit" className="login-btn btn btn-danger btn-block">SIGN IN</button>
                        </div>
                    </form>
                </div>

                <footer>
                    <div className="search-footer-container">
                    <p className="footer-address-inner">School of Veterinary Medicine 
                                                    <br/>
                                                    2500 University Drive NW
                                                    <br/>
                                                    Calgary Alberta Canada</p>
                    </div>
                </footer>

            </div>
        );
    }
}