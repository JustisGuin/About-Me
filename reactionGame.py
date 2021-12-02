from gpiozero import LED, Button
from time import sleep
from random import uniform
from os import _exit

leftName = input("Left player, Type Name: ")
rightName = input("Right player, Type Name: ")
led = LED(4)
rightBTN = Button(15)
leftBTN = Button(14)

sleep(2)
led.on()
sleep(uniform(5,10))
led.off()

def pressed(button):
    if button.pin.number == 14:
        print(rightName + " won the game!")
    else:
        print(leftName + " won the game!")
    _exit(0)
    
rightBTN.when_pressed = pressed
leftBTN.when_pressed = pressed

def howLong():
    
    