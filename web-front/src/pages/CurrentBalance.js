import "./CSS/CurrentBalance.css";
import React, {useEffect, useState} from 'react';
import {Link, useNavigate} from "react-router-dom";
import {useForm} from "react-hook-form";
import axios from "axios";
import Home from "./Home";
const CurrentBalance = () => {
    const today = new Date();
    const navigate = useNavigate();

    /*const [transaction, setTransaction] = useState([]);

    useEffect(() => {
        transData();
    }, []);

    const transData = async () => {
        const {data} = await axios.get('http://localhost:9090/users/900beb9a-1c6d-4047-a1f8-f3d610f22d1f/transactions');
        setTransaction(data);
    };*/

    const {addMoney, addHandleSubmit} = useForm();
    const onAddBalanceSubmit = (data) => {
        const obj2 = {
            name: data.name,
            account_number: data.account_number,
            amount: data.amount
        }
        axios
            .post("", obj2, {withCredentials: true})
            .then((res) => {
                const data = res.data;
            })
            .catch((err) => {
                console.log(err);
            });
    };

    const {balance, handleSubmit} = useForm();
    const onBalanceSubmit = (data) => {
        const obj1 = {
            name: data.name,
            account_number: data.account_number,
        };
        axios
            .post("", obj1, {withCredentials: true})
            .then((res) => {
                const data = res.data;
            })
            .catch((err) => {
                console.log(err);
            });
    };
 const { removeMoney, removeHandleSubmit } = useForm();
  const onRemoveBalanceSubmit = (data) => {
    const obj3 = {
      name: data.name,
      account_number: data.account_number,
      amount: data.amount
    }
    axios
      .post("", obj3, {withCredentials: true})
      .then((res) => {
        const data = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  }
    return (
        <div className="current-balance">
            <div className={"row form-box"}>
                <div className={"col-6 p-3"}>
                    <div className={"box-card card"}>
                        <div className={"card-header"}>
                            <h3 className={"mt-1"}>Current Balance</h3>
                        </div>
                        <div className={"card-body"}>
                            <div className={"row"}>
                                <div className={"col-6"}>
                                    <div className="registration-form">
                                        <form onSubmit={handleSubmit(onBalanceSubmit)}>
                                            <div className="form-group">
                                                <input type="text" className="form-control item"
                                                       placeholder="Account Holder Name" name={"name"} ref={balance}/>
                                            </div>
                                            <div className="form-group">
                                                <input type="text" className="form-control item"
                                                       placeholder="Account Number" name={"account_number"}
                                                       ref={balance}/>
                                            </div>
                                            <div className="form-group">
                                                <input type="text" className="form-control item" placeholder="Pin"
                                                       disabled={"true"} value={"4 2 6 2 7 8"}/>
                                            </div>
                                            <div className="form-group">
                                                <button type="submit" className="btn btn-block create-account">Check
                                                    Balance
                                                </button>
                                            </div>
                                        </form>
                                        <div className="text-center small mt-4 p-3">Don't have an bank
                                            account? &nbsp;&nbsp;&nbsp;<Link to={"/home"}>
                                                <button className={"btn btn-outline-secondary"}> Click Here</button>
                                            </Link>
                                        </div>
                                    </div>
                                </div>
                                <div className={"col-6"}>
                                    <div className="registration-form">
                                        <div className={"balance-box"}>
                                            <p className={"balance-title"}>Current Balance :</p>

                                            <div className="form-group d-flex item">
                                                <input type="text" className="form-control" placeholder="Account Number"
                                                       disabled={"true"}/><p className={"price"}>.Rs</p>
                                            </div>
                                            <p className={"balance-title"}>Today Date & Time :</p>
                                            <div className="form-group d-flex item">
                                                <input type="text" className="form-control" placeholder="Account Number"
                                                       value={today.getDate() + ' / ' + (today.getMonth() + 1) + ' / ' + today.getFullYear()}
                                                       disabled={"true"}/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className={"col-6 p-3"}>
                    <div className={"card"}>
                        <div className={"card-header"}>
                            <h3 className={"mt-1"}>Money Transaction</h3>
                        </div>
                        <div className={"card-body"}>
                            <div className={"row"}>
                                <div className={"col-6"}>
                                    <div className="registration-form">
                                        <form onSubmit={addHandleSubmit(onAddBalanceSubmit)}>
                                            <div className="card-title fs-4">Add Money</div>
                                            <div className="form-group">
                                                <input type="text" className="form-control item"
                                                       placeholder="Account Holder Name" name={"name"} ref={addMoney}/>
                                            </div>
                                            <div className="form-group">
                                                <input type="text" className="form-control item"
                                                       placeholder="Account Number" name={"account_number"}
                                                       ref={addMoney}/>
                                            </div>
                                            <div className="form-group">
                                                <input type="text" className="form-control item"
                                                       placeholder="Add Money" name={"amount"} ref={addMoney}/>
                                            </div>
                                            <div className="form-group">
                                                <button type="submit" className="btn btn-block create-account">Done
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <div className={"col-6"}>
                                    <div className="registration-form">
                                        <form onSubmit={removeHandleSubmit(onRemoveBalanceSubmit)}>
                                            <div className="card-title fs-4">Withdraw Money</div>
                                            <div className="form-group">
                                                <input type="text" className="form-control item"
                                                       placeholder="Account Holder Name" name={"name"} ref={removeMoney}/>
                                            </div>
                                            <div className="form-group">
                                                <input type="text" className="form-control item"
                                                       placeholder="Account Number" name={"account_number"} ref={removeMoney}/>
                                            </div>
                                            <div className="form-group">
                                                <input type="text" className="form-control item"
                                                       placeholder="Add Money" name={"amount"} ref={removeMoney}/>
                                            </div>
                                            <div className="form-group">
                                                <button type="submit" className="btn btn-block create-account">Done
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Home/>
        </div>
    );
}

export default CurrentBalance;
